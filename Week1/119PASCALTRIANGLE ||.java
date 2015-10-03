public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res=new ArrayList<Integer>(rowIndex+1);
        res.add(1);
        if(rowIndex==0){
            return res;
        }
        res.add(1);
        if(rowIndex==1){
            return res;
        }
        
        for(int i=2;i<rowIndex+1;i++){
            int temp=res.get(0);
            for(int j=1;j<res.size();j++){
                int adding=res.get(j)+temp;
                temp=res.get(j);
                res.set(j,adding);
            }
            res.add(1);
        }
        return res;
        
        
    }
}