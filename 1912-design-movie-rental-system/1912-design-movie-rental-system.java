class MovieRentingSystem {
    private class Movie {
        int shop;
        int price;

        Movie(int shop, int price) {
            this.shop = shop;
            this.price = price;
        }
    }

    private class Rent {
        int shop;
        int movie;
        int price;

        Rent(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    Map<Integer, TreeSet<Movie>> movies = new HashMap<>();
    TreeSet<Rent> rentedMovies = new TreeSet<>((a,b)-> {
    if(a.price!=b.price)return Integer.compare(a.price, b.price);
    if(a.shop!=b.shop) return Integer.compare(a.shop, b.shop);
    return Integer.compare(a.movie, b.movie);});
    Map<String, Integer> priceMap = new HashMap<>();


    public MovieRentingSystem(int n, int[][] entries) {
        for(int[] e : entries){
            int shop = e[0], movie = e[1], price = e[2];

            String key = getKey(shop, movie);
            priceMap.put(key, price);

            movies.computeIfAbsent(movie, k->new TreeSet<>((a,b)->{
                if(a.price!=b.price)return Integer.compare(a.price, b.price);
                return Integer.compare(a.shop, b.shop);
            })).add(new Movie(shop, price));
        }
    }

    private String getKey(int shop , int price){
        return shop + "_" + price;
    }

    public List<Integer> search(int movie) {
        int count = 0;
        List<Integer> shops = new ArrayList<>();
        for(Movie m : movies.get(movie)){
            if(count==5)break;
            shops.add(m.shop);
            count++;
        }
        return shops;
    }

    public void rent(int shop, int movie) {
        String key = getKey(shop, movie);
        int price = priceMap.get(key);
        rentedMovies.add(new Rent(shop, movie, price));

        TreeSet<Movie> availableMovies = movies.get(movie);
        availableMovies.remove(new Movie(shop, price));
    }

    public void drop(int shop, int movie) {
        String key = getKey(shop, movie);
        int price = priceMap.get(key);
        rentedMovies.remove(new Rent(shop, movie, price));

        TreeSet<Movie> availableMovies = movies.get(movie);
        availableMovies.add(new Movie(shop, price));
        movies.put(movie, availableMovies);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;

        for (Rent m : rentedMovies) {
            if (count == 5) {
                break;
            }

            result.add(Arrays.asList(m.shop, m.movie));

            count ++;
        }

        return result;
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