class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        String smallest = s;

        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(cur.compareTo(smallest)<0){
                smallest = cur;
            }

            char[] chars = cur.toCharArray();
            for(int i = 1; i < chars.length; i += 2){
                chars[i] = (char)((chars[i] - '0' + a)% 10 + '0');
            }
            String str = new String(chars);
            if(visited.add(str)){
                queue.offer(str);
            }
            String rotated = cur.substring(cur.length()-b) + cur.substring(0, cur.length() - b);
            if(visited.add(rotated)){
                queue.offer(rotated);
            }
        }

        return smallest;
    }
}