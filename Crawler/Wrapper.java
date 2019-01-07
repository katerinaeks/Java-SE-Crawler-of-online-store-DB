package Crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wrapper 
{
    private String searchURL;// url pou emfanizei oles tis selides apotelesmatwn analoga me to keyword //ΠΡΕΠΕΙ ΣΕ ΜΙΑ ΕΠΑΝΑΛΗΠΤΙΚΗ ΔΙΑΔΙΚΑΣΙΑ ΝΑ ΧΤΥΠΑΩ ΟΛΑ ΤΑ URLS ΤΩΝ ΣΕΛΙΔΩΝ ΓΙΑ ΚΑΘΕ KEYWORD
    private String resultsURL;//url ths mias selidas apotelesmatwn gia to sugkekrimeno keyword
    private String keyword;
    private String UserAgent;
    private ArrayList<Product> ProductsList;
    private ArrayList<String[]> pagesRawData;
    private int SearchPages;
    
    public Wrapper(String keyword)
    {
        this.keyword=keyword;
        this.searchURL="http://www.plaisio.gr/search.aspx?keyword="+this.keyword;
        int number=this.getSearchPagesNumber()-((this.getSearchPagesNumber()-1)*10);
        this.resultsURL="http://www.plaisio.gr/search.aspx?start="+number+"&keyword="+this.keyword+"&sort=priceasc";
        this.SearchPages=0;
        this.UserAgent="Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0";
        this.ProductsList=new ArrayList();
    } 
    
    public Wrapper(String keyword,String useragent)
    {
        this.keyword=keyword;
        this.searchURL="http://www.plaisio.gr/search.aspx?keyword="+this.keyword;
        int number=this.getSearchPagesNumber()-((this.getSearchPagesNumber()-1)*10);
        this.resultsURL="http://www.plaisio.gr/search.aspx?start="+number+"&keyword="+this.keyword+"&sort=priceasc";
        this.SearchPages=0;
        this.UserAgent=useragent;
        this.ProductsList=new ArrayList();
    } 
    
    public Wrapper(String url,String resultsurl,String keyword,String useragent) 
    {
        this.searchURL=url;
        this.resultsURL=resultsurl;
        this.keyword=keyword;
        this.SearchPages=0;
        this.UserAgent=useragent;
        this.ProductsList=new ArrayList();
        this.pagesRawData=new ArrayList();
    }
    
    public void setSearchPagesNumber(int number)
    {
        this.SearchPages=number;
    }
    public int getSearchPagesNumber() {
        return this.SearchPages;
    }
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
    public void setSearchURL(String url)
    {
        this.searchURL=url;
    }
    public void setResultsURL(String resultsURL)
    {
        this.resultsURL = resultsURL;
    }
    public String getKeyword()
    {
        return keyword;
    }
    public String getSearchURL()
    {
        return this.searchURL;
    }
    public String getResultsURL()
    {
        return this.resultsURL;
    }
    public void setUserAgent(String agent) {
        this.UserAgent=agent;
    }
    public String getUserAgent() {
        return this.UserAgent;
    }
    
    public ArrayList<Product> getProductsList() {
        return this.ProductsList;
    }
    
    public void calculateResultPagesNumber() throws IOException { //ipologizei to megisto arithmo apotelesmatwn proiontwn gia ena keyword
        
        Document doc = Jsoup.connect(this.getSearchURL()).userAgent(this.getUserAgent()).timeout(0).get();
        Elements productsSearchResults=doc.select("div.paginationNumbers");
        String encoded=productsSearchResults.text();
        if (!encoded.equals("")) {
          if (encoded.contains("...")) {
              String[] decode1=encoded.split(" ");
              String[] decode2=decode1[0].split(Pattern.quote("..."));
              this.setSearchPagesNumber((Integer.parseInt(decode2[1])-1)*10);
          } else { 
           String decoded=Character.toString(encoded.charAt(encoded.length()-1));
           this.setSearchPagesNumber((Integer.parseInt(decoded)-1)*10);
          }
        }
        else
        this.setSearchPagesNumber(0);
    }
    
    public ArrayList<Product> fetchHttpProductsData() throws IOException { //swzei se ena arraylist pou o kathe komvos tou einai pinakas me string tis plirofories olwn twn proiontwn pou exoun ola ta result pages
        this.calculateResultPagesNumber();
        Elements productsRawInfo=null;
        for(int i=0;i<=this.getSearchPagesNumber();i=i+10) {
            Document doc = Jsoup.connect("http://www.plaisio.gr/search.aspx?start="+Integer.toString(i)+"&keyword="+this.getKeyword()+"&sort=priceasc").userAgent(this.getUserAgent()).timeout(0).get();
            
             Elements productsInfo=doc.select("ul#search-grid").select("li").select("div.product-info");//
             Elements productsDescription=doc.select("ul#search-grid").select("li").select("div.description");//
             Elements productsCodes=doc.select("ul#search-grid").select("li").select("div.text");//
             Elements productsPrice=doc.select("ul#search-grid").select("li").select("div.product-price");//
             Elements imageLinks=doc.select("ul#search-grid").select("li").select("a").select("img.photo");//
             for (int j=0;j<productsInfo.size();j++) {
                Product temp=new Product(); 
                Element productInfo=productsInfo.get(j);
                String[] decode=productInfo.text().trim().split(Pattern.quote("Κωδικός:")); 
                temp.SetNameProduct(decode[0].trim());
                String[] brandDecode=productInfo.text().trim().split(Pattern.quote(" "));
                char delimiter=160;
                String[] brandDecode1=brandDecode[0].split(Character.toString(delimiter));
                temp.SetBrand(brandDecode1[0]);
                Element productCode=productsCodes.get(j);
                String[] codeDecode=productCode.text().split(" ");
                String[] codeDecode2=codeDecode[0].split(":");
                temp.SetCode(codeDecode2[1]);
                Element productDescription=productsDescription.get(j);
                temp.setProductDescription(productDescription.text());
                Element productPrice=productsPrice.get(j);
                temp.SetPriceProduct(productPrice.text());
                Element productImageLink=imageLinks.get(j);
                temp.seturlPic("http://www.plaisio.gr/"+productImageLink.attr("src").trim());
                this.getProductsList().add(temp);
             }
        }
        return this.ProductsList;
    }
    
    
    /* help: http://stackoverflow.com/questions/2835505/how-to-scan-a-website-or-page-for-info-and-bring-it-into-my-program */
    
}