package IN_OUT;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InsertarImagenPDF {



    public static void main(String[] args) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource("foto2.jpg").toURI());

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject image
                = PDImageXObject.createFromFile(path.toAbsolutePath().toString(), document);
        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        document.save("pdfBoxImage.pdf");
        document.close();
        } catch (URISyntaxException | IOException e  ) {
            throw new RuntimeException(e);
        }

        //main
    }

    //class
}
