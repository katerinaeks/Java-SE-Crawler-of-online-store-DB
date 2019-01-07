  
package Crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
    private static Object doc;
    private static String url;
    private static Object link;
    
    public static void main(String[] args) throws IOException {
    
      //  Wrapper con=new Wrapper("graphics");
      // System.out.println(con.connectdebug(con.getResultsURL()));
        
        
    //    Document doc = Jsoup.connect("http://www.plaisio.gr/search.aspx?start=0&keyword=graphics&sort=priceasc").get();
        
         //bigSearchContainer
    /*       Elements productss=doc.select("ul#search-grid").select("li");
           for(int i=0;i<productss.size();i++) {
               System.out.println("**********");
               Element temp=productss.get(i);
               System.out.println(temp.text());
               System.out.println("**********");
           } */
       
   /*      Elements productss=doc.select("ul#search-grid").select("li").select("div.description");
         System.out.println("Description Size:"+productss.size());
         for(int i=0;i<productss.size();i++) {
               System.out.println("**********");
               Element temp=productss.get(i);
               System.out.println(temp.text());
               System.out.println("**********");
           } 
         Elements code=doc.select("ul#search-grid").select("li").select("div.text");
         System.out.println("Code Size:"+code.size()); 
         for(int i=0;i<code.size();i++) {
               System.out.println("-----------");
               Element temp=code.get(i);
               System.out.println(temp.text());
               System.out.println("------------");
           } 
          
         Elements price=doc.select("ul#search-grid").select("li").select("div.product-price");
         System.out.println("Price Size:"+price.size()); 
         for(int i=0;i<price.size();i++) {
               System.out.println("//////////////");
               Element temp=price.get(i);
               System.out.println(temp.text());
               System.out.println("//////////////");
           } 
          
         // Elements info=doc.select("ul#search-grid").select("a[href]");
          
          Elements info=doc.select("ul#search-grid").select("li").select("div.product-info");
          System.out.println("Product Info Size:"+info.size());
          for(int i=0;i<info.size();i++) {
               System.out.println("\\\\\\\\\\\\\\\\");
               Element temp=info.get(i);
               System.out.println(temp.text());
               System.out.println("\\\\\\\\\\\\\\\\");
           } 
          
          Elements imageLinks=doc.select("ul#search-grid").select("li").select("a").select("img.photo");
          System.out.println("Photo Links Size:"+imageLinks.size());
          for(int i=0;i<imageLinks.size();i++) {
               System.out.println("+++++++++++++++++");
               Element temp=imageLinks.get(i);
               System.out.println(temp.attr("src"));
               System.out.println("+++++++++++++++++");
           } 
          
       */
        //   Elements price=doc.select("ul#search-grid").select("div.product-price");
        //   Elements product=doc.select("li.even searchNormalBlock");
        //   System.out.println(productss.text());
        //   System.out.println(price.text());
        //   System.out.println(product.text());
       //    String[] decoded=productss.text().split(" ");
       //    for(int i=0;i<decoded.length;i++)
        //   {
        //       System.out.println(decoded[i]);
       //    }

          //System.out.println(doc.toString());
     //       String title=doc.title();
           // System.out.println(doc.toString());
           // System.out.println(title);
          // Elements productss=doc.select("div#searchMainCol").select("li");
    //     Elements productss=doc.select("div#ctl00_ctl00_BaseLayoutContentArea_MainContent_searchResults_topPaging_divPager"); 
        // System.out.println(productss.text());
    //     String temp=productss.text();
    //     String[] decoded=temp.split(Pattern.quote("..."));
    //     System.out.println(decoded[0]);
    //     System.out.println(decoded[1]);
    //    for (Element Link : productss) {
    //        System.out.println(Link.text());
    //    }
        String keyword="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dwse kleidi anazitisis apo to plaisio:");
        keyword=br.readLine();
        Wrapper katerina=new Wrapper(keyword);
        katerina.calculateResultPagesNumber(); //ipologizei to megisto arithmo proiontwn gia na kserw se poses result pages tha sindetho
        ArrayList<Product> temp=katerina.fetchHttpProductsData();
        for(int i=0;i<temp.size();i++) {
            System.out.println("**************************************************************");
            System.out.println("Product Name:"+temp.get(i).GetNameProduct());
            System.out.println("Product Brand:"+temp.get(i).GetBrand());
            System.out.println("Product Description:"+temp.get(i).getProductDescription());
            System.out.println("Product Price:"+temp.get(i).GetPriceProduct());
            System.out.println("Product Code:"+temp.get(i).GetCode());
            System.out.println("Product Image URL:"+temp.get(i).geturlPic());
            System.out.println("**************************************************************");
        }
        Database.init();
       
    }
    
}