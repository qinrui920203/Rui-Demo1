package demo.test;

public class QuestOne {

    static int n=12;
    static int m=3;

    public static void main(String[] args) {

        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }

        int count=0;//该变量记录数数次数,理论最多数n*m次
        while(true) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]!=0) {
                    count++;
                    if(count%m==0) {
                        System.out.print(i+1+" ");
                        arr[i]=0;
                    }
                    if(count==n*m) {//实际当最后第二个出圈,谁最后一个出圈的也就出来,暂不考虑
                        return;
                    }
                }
            }
        }
    }
}



