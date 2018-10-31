import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //HashMap<Integer, Map> maps = new HashMap<Integer, Map>();
        for(int i = 0;i<n;i++){
            int k = input.nextInt();
            map.put(i+1,k);
           // maps.put(i+1,map);
        }

        if(map.size()>0&&!map.isEmpty()){
            del(map);
            for(Map.Entry entry :map.entrySet()){
                System.out.println(entry.getValue());
                System.out.println(entry.getKey());
            }
        }else{
            System.out.println(0);
        }

        input.close();
    }

    private static void del(HashMap<Integer, Integer> map) {
        if(map.size()==1){
            return ;
        }
        int index = 1;
        List list = new ArrayList();
        for(Map.Entry entry :map.entrySet()){
            if(index%2==1){
//                map.remove(entry.getKey());
                list.add(entry.getKey());
            }
            index++;
//            list.add(entry);
            //System.out.println(entry.getKey()+" val:"+entry.getValue());
        }

        for(int i = 0;i<list.size();i++){
            map.remove(list.get(i));
        }
        del(map);
    }
}
