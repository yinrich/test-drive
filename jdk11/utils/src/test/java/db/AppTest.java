package db;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;

import java.sql.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Ignore
    @Test
    public void shouldAnswerWithTrue()
    {
        boolean success = false;
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.0.48/bruno?user=bruno&password=bruno&ssl=false";
            conn = DriverManager.getConnection(url);
            var exporter = new QueryExporter(conn);
            var rs = exporter.runQuery();
            String csvFilename = "test-bean.csv";
            exporter.beanExport(rs, csvFilename);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (conn != null){
                try {
                    conn.close();
                } catch (Exception e) {
                    // ignore errors
                }
            }
        } 
        assertTrue( success );
    }
}
