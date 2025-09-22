class MovieRentingSystem {
    class PriceShop implements Comparable<PriceShop>{
        int price, shop;
        PriceShop(int p, int s){
            this.price = p;
            this.shop = s;
        }
        public int compareTo(PriceShop obj){
            if(this.price != obj.price) return this.price-obj.price;
            return this.shop - obj.shop;
        }
        @Override
        public boolean equals(Object o){
            if(!(o instanceof PriceShop)) return false;
            PriceShop p = (PriceShop) o;
            return price == p.price && shop == p.shop;
        }
        @Override
        public int hashCode(){
            return Objects.hash(price, shop);
        }
    }

    class RentedMovie implements Comparable<RentedMovie>{
        int price, shop, movie;
        RentedMovie(int p, int s, int m){
            this.price = p;
            this.shop = s;
            this.movie = m;
        }
        public int compareTo(RentedMovie obj){
            if(this.price != obj.price) return this.price - obj.price;
            if(this.shop != obj.shop) return this.shop - obj.shop;
            return this.movie - obj.movie;
        }
        @Override
        public boolean equals(Object o){
            if( !(o instanceof RentedMovie)) return false;
            RentedMovie r = (RentedMovie) o;
            return price == r.price && shop == r.shop && movie == r.movie;
        }
        @Override
        public int hashCode(){
            return Objects.hash(price, shop, movie);
        }
    }

    Map<Integer, TreeSet<PriceShop>> available;
    Map<Integer, Map<Integer, Integer>> movieToShopPrice;
    TreeSet<RentedMovie> rented;


    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        movieToShopPrice = new HashMap<>();
        rented = new TreeSet<>();
        
        for(int [] e: entries){
            int shop = e[0], movie = e[1], price = e[2];
            available.computeIfAbsent(movie, k -> new TreeSet<>()).add(new PriceShop(price, shop));
            movieToShopPrice.computeIfAbsent(movie, k -> new HashMap<>()).put(shop, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if(available.containsKey(movie)){
            int count = 0;
            for(PriceShop p: available.get(movie)){
                ans.add(p.shop);
                count++;
                if(count >= 5) break;
            }
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        int price = movieToShopPrice.get(movie).get(shop);
        available.get(movie).remove(new PriceShop(price, shop));
        rented.add(new RentedMovie(price, shop, movie));
    }
    
    public void drop(int shop, int movie) {
        int price = movieToShopPrice.get(movie).get(shop);
        available.get(movie).add(new PriceShop(price, shop));
        rented.remove(new RentedMovie(price, shop, movie));
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> rep = new ArrayList<>();
        int count = 0;
        for(RentedMovie rm: rented){
            rep.add(Arrays.asList(rm.shop, rm.movie));
            count++;
            if(count >= 5){
                break;
            }
        }
        return rep;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */