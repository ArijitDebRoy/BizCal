
package Utility;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Carousals.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import java.text.ParseException;

public class GenerateBill {

    private static final Font NORMAL_UNDERLINED = new Font(Font.FontFamily.COURIER, 10, Font.UNDERLINE, BaseColor.BLACK);
    private static final Font NORMAL_BOLD = new Font(Font.FontFamily.COURIER, 8, Font.BOLD, BaseColor.BLACK);
    private static final Font NORMAL_BOLD_HEAD = new Font(Font.FontFamily.COURIER, 26, Font.BOLD, BaseColor.BLACK);
    private static final Font NORMAL = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    private static final Font MEDIUM_HELVETICA = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
    private static final Font SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
    private static final Font MEDIUM_TIMES = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.BLACK);
     private static final Font NORMAL_FINE = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);

    private static BuyerCarousal buyer;
    private static OrderCarousal oc;
    private static OrderedProductCarousal op;
    private static OwnerCarousal owner;

    public GenerateBill(BuyerCarousal b, OrderCarousal o, OwnerCarousal own, OrderedProductCarousal op) {
        this.buyer = b;
        this.oc = o;
        this.op = op;
        this.owner = own;
    }

    private static void addHeader(Document doc) throws DocumentException, ParseException {

        Paragraph title = new Paragraph("TAX INVOICE", NORMAL_UNDERLINED);
        title.setAlignment(Element.ALIGN_CENTER);
        Paragraph invoice_style = new Paragraph("DUPLICATE-SELLER'S COPY", NORMAL_BOLD);
        invoice_style.setAlignment(Element.ALIGN_RIGHT);

        Phrase company_name = new Phrase(owner.company, NORMAL_BOLD_HEAD);
        Phrase company_address = new Phrase(owner.address, MEDIUM_HELVETICA);
        Paragraph company = new Paragraph(company_name);
        company.add(Chunk.NEWLINE);
        company.add(company_address);
        company.setAlignment(Element.ALIGN_MIDDLE);

        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd");
        Date dtemp = temp.parse(oc.order_date);

        String stemp = "Tax Invoice No.:- " + oc.tax_invoice_no + "\nChallan No.:- " + oc.challan_no + "\nOrder No.:- " + oc.order_no + "\nDate:- " + new SimpleDateFormat("dd-MM-yyyy").format(dtemp);//oc.order_date; 
        Paragraph order_info = new Paragraph(stemp,NORMAL_FINE);
        order_info.setAlignment(Element.ALIGN_RIGHT);

        stemp = "Buyer's Name:- " + buyer.name + "\nBuyer's Address:- " + buyer.address + "\nBuyer's VAT No.:- " + buyer.vat_no;
        Paragraph buyer_info = new Paragraph(stemp,NORMAL_FINE);
        buyer_info.setAlignment(Element.ALIGN_RIGHT);

        Date vat_temp = temp.parse(owner.vat_date);
        Date cst_temp = temp.parse(owner.cst_date);

        stemp = "Phone No:- " + owner.phone + "\nMobile No.:- " + owner.mobile + "\nVAT Registration No.:-" + owner.vat_no + "\nDt. " + new SimpleDateFormat("dd-MM-yyyy").format(vat_temp) + "\nC.S.T Registration No.:- " + owner.cst_no + "" + "\nDt. " + new SimpleDateFormat("dd-MM-yyyy").format(cst_temp);
        Paragraph owner_info = new Paragraph(stemp,NORMAL_FINE);

        PdfPTable section1 = new PdfPTable(2);
        section1.setWidthPercentage(100);
        PdfPCell cell1 = new PdfPCell(company);
        cell1.setBorder(PdfPCell.NO_BORDER);
        PdfPCell cell2 = new PdfPCell(order_info);
        cell2.setBorder(PdfPCell.NO_BORDER);
        cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);

        section1.addCell(cell1);
        section1.addCell(cell2);

        PdfPTable section2 = new PdfPTable(2);
        section2.setWidthPercentage(100);
        cell1 = new PdfPCell(owner_info);
        cell1.setBorder(PdfPCell.NO_BORDER);
        cell2 = new PdfPCell(buyer_info);
        cell2.setBorder(PdfPCell.NO_BORDER);
        cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);

        section2.addCell(cell1);
        section2.addCell(cell2);

        try {
            doc.add(invoice_style);
            doc.add(title);
            doc.add(Chunk.NEWLINE);
            doc.add(section1);
            doc.add(Chunk.NEWLINE);
            doc.add(section2);
        } catch (DocumentException ex) {
            Logger.getLogger(GenerateBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addContent(Document doc) throws DocumentException {
        try {
            PdfPTable table = new PdfPTable(8);
            float PageWidth = doc.getPageSize().getWidth();
            float s01 = (float) (PageWidth * 0.1);
            float s03 = (float) (PageWidth * 0.3);
            table.setWidthPercentage(new float[]{s01, s01, s03, s01, s01, s01, s01, s01}, doc.getPageSize());

            PdfPCell sl_no = new PdfPCell(new Phrase("Sl. No", NORMAL));
            sl_no.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell qty = new PdfPCell(new Phrase("Quantity", NORMAL));
            qty.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell description_of_good = new PdfPCell(new Phrase("Description of goods", NORMAL));
            description_of_good.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell rate = new PdfPCell(new Phrase("Price per unit", NORMAL));
            rate.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell value = new PdfPCell(new Phrase("Value (Rs.)", NORMAL));
            value.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell vat_rate = new PdfPCell(new Phrase("VAT rate", NORMAL));
            vat_rate.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell tax_amount = new PdfPCell(new Phrase("Tax amount (Rs.)", NORMAL));
            tax_amount.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell total = new PdfPCell(new Phrase("Total (Rs.)", NORMAL));
            total.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(sl_no);
            table.addCell(qty);
            table.addCell(description_of_good);
            table.addCell(rate);
            table.addCell(value);
            table.addCell(vat_rate);
            table.addCell(tax_amount);
            table.addCell(total);

            doc.add(Chunk.NEWLINE);

            for (int j = 0; j < op.ProductCount + 3; j++) {
                for (int i = 0; i < 8 && j < op.ProductCount; i++) {
                    PdfPCell temp = null;
                    switch (i) {
                        case 0:
                            temp = new PdfPCell(new Phrase(String.valueOf(j + 1) + ".", SMALL));
                            break;
                        case 1:
                            temp = new PdfPCell(new Phrase(op.qty[j], SMALL));
                            break;
                        case 2:
                            temp = new PdfPCell(new Phrase(op.prod[j], SMALL));
                            break;
                        case 3:
                            temp = new PdfPCell(new Phrase(op.rate[j], SMALL));
                            break;
                        case 4:
                            temp = new PdfPCell(new Phrase(op.value[j], SMALL));
                            break;
                        case 5:
                            temp = new PdfPCell(new Phrase("", SMALL));
                            break;
                        case 6:
                            temp = new PdfPCell(new Phrase("", SMALL));
                            break;
                        case 7:
                            temp = new PdfPCell(new Phrase("", SMALL));
                            break;
                    }
                    temp.setBorder(PdfPCell.NO_BORDER);
                    temp.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(temp);

                }
                if (j >= op.ProductCount) {
                    for (int k = 0; k < 8; k++) {
                        PdfPCell temp;
                        if (k == 7 && j == op.ProductCount) {
                            temp = new PdfPCell(new Phrase(String.valueOf(op.total), SMALL));
                            temp.setHorizontalAlignment(Element.ALIGN_CENTER);
                        } else if (k == 6 && j == op.ProductCount + 1) {
                            temp = new PdfPCell(new Phrase(String.valueOf(op.tax_amt), SMALL));
                            temp.setBorder(PdfPCell.NO_BORDER);
                            temp.setHorizontalAlignment(Element.ALIGN_CENTER);
                        } else if (k == 5 && j == op.ProductCount + 1) {
                            temp = new PdfPCell(new Phrase(String.valueOf(op.vat_rate), SMALL));
                            temp.setBorder(PdfPCell.NO_BORDER);
                            temp.setHorizontalAlignment(Element.ALIGN_CENTER);
                        } else if (k == 7 && j == op.ProductCount + 2) {
                            temp = new PdfPCell(new Phrase(String.valueOf(op.total_inc_tax), SMALL));
                            temp.setHorizontalAlignment(Element.ALIGN_CENTER);
                        } else {
                            temp = new PdfPCell(new Phrase("", SMALL));
                            if (j == op.ProductCount + 1) {
                                temp.setBorder(PdfPCell.NO_BORDER);
                            }
                        }
                        table.addCell(temp);
                    }
                }
            }

            doc.add(table);
            Paragraph grand_total = new Paragraph("Amount payable(in words) : " + DigConvert.convertToText(String.valueOf(op.total_inc_tax), "") + " Rupees Only.");
            
            for (int i = 0; i < 4; i++) {
                doc.add(Chunk.NEWLINE);
            }
            doc.add(grand_total);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void addFooter(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("(This is a computer generated bill)", SMALL);
        String sig_temp="Authorised Signatory";
        Paragraph sig = new Paragraph(sig_temp, new Font(Font.FontFamily.COURIER, 10));
        String temp = "for - (" + owner.company + ")";
        Paragraph company_name = new Paragraph(temp, new Font(Font.FontFamily.COURIER, 10, Font.BOLD));
        int offset=Math.abs(temp.length()+sig_temp.length())/2;
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,
                sig,
                (document.right() - document.rightMargin() - offset),
                document.bottom() + 30, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,
                company_name,
                (document.right() - document.rightMargin()),
                document.bottom() + 60, 0);
    }

    public void generate() {

        try {
            String loc;
            if (System.getProperty("os.name").contains("Windows"))
                loc = "C:/Users/" + System.getProperty("user.name") + "/Desktop/Bill_" + new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date()) + ".pdf";
            else
                loc = "/home/" + System.getProperty("user.name") + "/Desktop/Bill_" + new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date()) + ".pdf";
            Document doc = new Document(PageSize.LETTER);
            FileOutputStream current = new FileOutputStream(loc);
            PdfWriter temp = PdfWriter.getInstance(doc, current);

            doc.open();
            addHeader(doc);
            addContent(doc);
            addFooter(temp, doc);
            doc.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
