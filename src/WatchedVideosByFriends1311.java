import java.util.*;

public class WatchedVideosByFriends1311 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 3,2,1,4};
        int[] intArray2 = new int[]{ 0,4};
        int[] intArray3 = new int[]{ 4,0};
        int[] intArray4 = new int[]{ 0,4};
        int[] intArray5 = new int[]{ 2,3,1,0};
        List<List<String>> watchedVideos = new ArrayList<>();
        List<String> watchedVideo1 = new ArrayList<>();
        watchedVideo1.add("bjwtssmu");
      //  watchedVideo1.add("B");
        List<String> watchedVideo2 = new ArrayList<>();
        watchedVideo2.add("aygr");
        watchedVideo2.add("mqls");
        List<String> watchedVideo3 = new ArrayList<>();
        watchedVideo3.add("vrtxa");
        watchedVideo3.add("zxqzeqy");
        watchedVideo3.add("nbpl");
        watchedVideo3.add("qnpl");
        List<String> watchedVideo4 = new ArrayList<>();
        watchedVideo4.add("r");
        watchedVideo4.add("otazhu");
        watchedVideo4.add("rsf");
        List<String> watchedVideo5 = new ArrayList<>();
        watchedVideo5.add("bvcca");
        watchedVideo5.add("ayyihidz");
        watchedVideo5.add("ljc");
        watchedVideo5.add("fiq");
        watchedVideo5.add("viu");
        watchedVideos.add(watchedVideo1);
        watchedVideos.add(watchedVideo2);
        watchedVideos.add(watchedVideo3);
        watchedVideos.add(watchedVideo4);
        watchedVideos.add(watchedVideo5);

        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4,intArray5 };

      /*  int[] intArray1 = new int[]{ 1,2};
        int[] intArray2 = new int[]{ 3};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ };
      //  int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };
*/



        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);


        System.out.println("Final result"+ watchedVideosByFriends(watchedVideos,graphArrays,3,1) );
       // System.out.println("Final result"+ watchedVideosByFriends(watchedVideos,graphArrays,0,2) );


    }


    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> resultList = new ArrayList<>();
        Map<Integer, List<String>> friendsVideoMap = new HashMap<>();
        Map<Integer, List<Integer>> friendsGraph = new HashMap<>();
        Set<Integer> visistedFriends = new HashSet<>();


        for (int i=0; i<friends.length; i++) {
            int[] nodes =friends[i];
            List<Integer> listNodes = new ArrayList<>();
            for (int j=0; j<nodes.length; j++) {
                listNodes.add(nodes[j]);
            }
            friendsGraph.put(i, listNodes);
        }
        System.out.println(friendsGraph);



        //  dfsWatchedVideosByFriendsHelper( id, level,friendsVideoMap,friendsGraph,watchedVideos,visistedFriends,0);
        return  bfsWatchedVideosByFriendsHelper( id, level,friendsGraph,watchedVideos,visistedFriends);

    }

    private static void dfsWatchedVideosByFriendsHelper(int source, int level, Map<Integer, List<String>> friendsVideoMap, Map<Integer, List<Integer>> friendsGraph, List<List<String>> watchedVideos, Set<Integer> visistedFriends, int currentLevel) {
     System.out.println("currentLevel"+currentLevel);
        System.out.println("level"+level);
        System.out.println("source"+source);

     visistedFriends.add(source);
        System.out.println("visistedFriends"+visistedFriends);
    // List<String> watchedVideoList = watchedVideos.get(source);
     if(friendsVideoMap.containsKey(currentLevel)) {
         List<String> watchedVideo = friendsVideoMap.get(currentLevel);
         watchedVideo.addAll(watchedVideos.get(source));
     }else{
         List<String> watchedVideo = new ArrayList<>();
         watchedVideo.addAll(watchedVideos.get(source));
         friendsVideoMap.put(currentLevel, watchedVideo);
     }

     if(currentLevel < level) {
        List<Integer>  neighbourNodes = friendsGraph.get(source);
        for (Integer neighbourNode : neighbourNodes) {
            if(!visistedFriends.contains(neighbourNode)) {
                //dfs
                dfsWatchedVideosByFriendsHelper(neighbourNode,level,friendsVideoMap,friendsGraph,watchedVideos,visistedFriends,currentLevel+1);
            }
        }


     }

    }

    private static  List<String> bfsWatchedVideosByFriendsHelper(int source, int level, Map<Integer, List<Integer>> friendsGraph, List<List<String>> watchedVideos, Set<Integer> visistedFriends) {
        List<String> resultList = new ArrayList<>();
        HashMap<String, Integer> counts = new HashMap();
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue(new MapComparator());

        // node,level
        Map<Integer, Integer> nodeLevelMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        nodeLevelMap.put(source,0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visistedFriends.add(node);
            List<Integer> immediateFriends = friendsGraph.get(node);
            for (Integer immediateFriend : immediateFriends) {

                if(!visistedFriends.contains(immediateFriend) && nodeLevelMap.get(node)<level ) {
                    System.out.println(" visistedFriends"+visistedFriends);
                    System.out.println(" immediateFriend"+immediateFriend);
                    queue.add(immediateFriend);
                    if(!nodeLevelMap.containsKey(immediateFriend)) {
                        nodeLevelMap.put(immediateFriend, nodeLevelMap.get(node) + 1);
                        if(nodeLevelMap.get(immediateFriend) == level) {
                            // resultList.addAll(watchedVideos.get(immediateFriend));
                            // add the contenets in a map to keep track of count.
                            for(String watchedVideo : watchedVideos.get(immediateFriend)) {
                                counts.put(watchedVideo, counts.getOrDefault(watchedVideo, 0)+1);
                            }

                        }
                    }
                    System.out.println(" resultList"+resultList);
                }
            }
        }
        System.out.println("nodeLevelMap"+nodeLevelMap);
        System.out.println("final resultList"+resultList);
        System.out.println("counts map"+counts);

        minHeap.addAll(counts.entrySet());
        System.out.println("minHeap"+minHeap);

        while(!minHeap.isEmpty()) {
            resultList.add(minHeap.poll().getKey());
        }
        return resultList;
    }
}

class MapComparator implements Comparator<Map.Entry<String, Integer>>  {

    // Overriding compare()method of Comparator
    // for descending order of cgpa



    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

        if(o1.getValue() > o2.getValue())
            return 1;
        else if (o1.getValue() < o2.getValue())
            return -1;
        else return o1.getKey().compareToIgnoreCase(o2.getKey());



    }
}
