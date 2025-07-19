class Tweet implements Comparable<Tweet>{
    int time;
    int tweetID;
    Tweet(int time, int tweetID){
        this.time = time;
        this.tweetID = tweetID;
    }
    public int compareTo(Tweet that){
        return that.time - this.time;
    }
}
class User{
    int userID;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User(int userID){
        this.userID = userID;
        followers = new HashSet<>();
        followers.add(userID);
        tweets = new LinkedList<>();
    }
    public void addTweet(Tweet t){
        tweets.add(0,t); //insertion at the head
    }
    public void addFollower(int followee){
        followers.add(followee);
    }
    public void removeFollower(int followee){
        followers.remove(followee);
    }

}
class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId))return new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        //add self + follower tweets
        User user = userMap.get(userId);
        for(int followerId : user.followers){
            int count = 0;
            for(Tweet tweet : userMap.get(followerId).tweets){
                pq.offer(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index<10){
            Tweet tweet = pq.poll();
            res.add(tweet.tweetID);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId))return;
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */