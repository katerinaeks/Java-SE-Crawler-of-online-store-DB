
package Crawler;


public class Product 
{


        private String nameProduct;
        private String priceProduct;
        private int availability;
        private String category;
        private String code;
        private String brand;
        private String guarantee;
        private float transportCost;
        private String deliveryTime;
        private String Description;
        String review;
        String payments;
        String returns;
        String itemLocation;
        String shipsTo;
        String shop;
        String urlPic;
              
        public Product()
        {
         this.nameProduct=("");
         this.priceProduct="";//double->float..?
         this.availability=0;
         this.category=("");
         this.code=("");
         this.brand=("");
         this.guarantee=("");
         this.transportCost=(float) 0.0;
         this.deliveryTime=("");
         this.review=("");
         this.payments=("");
         this.returns=("");
         this.itemLocation=("");
         this.shipsTo=("");
         this.shop=("");
         this.urlPic=("");
        }
      
        public void SetNameProduct(String onoma)
        {
            this.nameProduct=onoma;
        }
        public void SetPriceProduct(String price)
        {
            this.priceProduct=price;
        }
        public void SetAvailability(int availability)
        {
            this.availability=availability;
        }
         public void SetCategory(String category)
        {
            this.category=category;
        }
        public void SetCode(String code)
        {
            this.code=code;
        }
        public void SetBrand(String brand)
        {
            this.brand=brand;
        }
        public void SetGuarantee(String guarantee)
        {
            this.guarantee=guarantee;
        }
        public void SetTransportCost(float transportCost)
        {
            this.transportCost=transportCost;
        }
        public void setDeliveryTime(String deliveryTime)
        {
            this.deliveryTime = deliveryTime;
        }
        public void setReview(String review)
        {
            this.review = review;
        }
        public void setPayments(String payments)
        {
            this.payments = payments;
        }
        public void setReturns(String returns)
        {
            this.returns = returns;
        }
        public void setItemLocation(String itemLocation)
        {
            this.itemLocation = itemLocation;
        }
        public void setShipsTo(String shipsTo)
        {
            this.shipsTo = shipsTo;
        }
        public void setShop(String shop)
        {
            this.shop = shop;
        }
        public void seturlPic(String urlPic)
        {
            this.urlPic = urlPic;
        }
        
        public void setProductDescription(String description) {
            this.Description=description;
        }
        
        public String GetNameProduct()
        {
            return this.nameProduct;
        }
        public String GetPriceProduct()
        {
            return this.priceProduct;
        }
        public int GetAvailability()
        {
            return this.availability;
        }
        public String GetCategory()
        {
            return this.category;
        }
        public String GetCode()
        {
            return this.code;
        }
        public String GetBrand()
        {
            return this.brand;
        }
        public String GetGuarantee()
        {
            return this.guarantee;
        }
        public float GetTransportCost()
        {
            return this.transportCost;
        }
        public String getDeliveryTime()
        {
            return deliveryTime;
        }
        public String getReview()
        {
            return review;
        }
        public String getPayments()
        {
            return payments;
        }
        public String getReturns() 
        {
            return returns;
        }
        public String getItemLocation()
        {
            return itemLocation;
        }
        public String getShipsTo() 
        {
            return shipsTo;
        }
        public String getShop()
        {
            return shop;
        }
        public String geturlPic()
        {
            return urlPic;
        }
        
        public String getProductDescription() {
            return this.Description;
        }  
    }


