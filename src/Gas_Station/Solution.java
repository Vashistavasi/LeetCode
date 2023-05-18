package Gas_Station;

class Solution {
    public static void main(String[] args) {
        int gas[]={67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
        int cost[]={27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int len=gas.length;
        int res[]=new int[len];
        for(int i=0;i<len;i++)res[i]=gas[i]-cost[i];
        int sumFuel=0;
        for (int i : res) {
            sumFuel += i;
        }
        int ans=-1;
        if(sumFuel<0)
            return ans;
        int start=0;int fuel=0;
        for(int i=0;i<len;i++){
            start=i;
            int count=len;
            int k=0;
            while(count-->0){
                int idx=(start+k)%len;
                fuel+=res[idx];
                if(fuel<0){
                    break;
                }
                k++;
            }
            if(fuel>=0){ans=start;break;}
            else fuel=0;
        }
        return ans;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int ans=-1;
        int len=gas.length;
        int fuel=0;
        int start=0;
        int sumFuel=0,dis=0;
        for(int i:gas)sumFuel+=i;for(int i:cost)dis+=i;
        if(sumFuel<dis)return ans;
        for(int i=0;i<len;i++){
            start=i;
            int count=len;
            int k=0;
            while(count-->0){
                int idx=(start+k)%len;
                fuel+=gas[idx]-cost[idx];
                if(fuel<0)
                    break;
                k++;
            }
            if(fuel>=0){ ans=start; break;}
            else fuel=0;
        }
        return ans;
    }
}
