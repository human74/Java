package zad1;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
public class FileVisitor extends SimpleFileVisitor <Path> {

    private FileChannel output;
    private ByteBuffer Buffer1;
    public Charset inCharset = Charset.forName("Cp1250");
    public Charset outCharset = Charset.forName("UTF-8");

    public FileVisitor(Path outputFilePath) throws IOException {
        this.output = FileChannel.open(outputFilePath, EnumSet.of(CREATE, APPEND));
    }

    private void recodeUtf(FileChannel inputFileChannel, long bufferSize){

        Buffer1 = ByteBuffer.allocate((int)bufferSize +1);
        Buffer1.clear();

        try {
            inputFileChannel.read(Buffer1);
            Buffer1.flip();
            CharBuffer cbuf = inCharset.decode(Buffer1);
            ByteBuffer buf = outCharset.encode(cbuf);
            while( buf.hasRemaining() )
                this.output.write(buf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Path filePath, IOException e) {
        System.err.println("Filevisitor fail: " + e);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path filePath, BasicFileAttributes attributes) {

        System.out.format("plik o sciezce: ", filePath);
        System.out.println("( " + attributes.size() + "bajtow )");

        try {
            this.recodeUtf(FileChannel.open(filePath), attributes.size());
        } catch(IOException ex){
            System.out.format("błąd tworzenia pliku o sciezce : ", filePath);
        }
        return CONTINUE;
    }
}