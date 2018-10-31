package sortTest;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {

        //ð��������Զ��֤��һ������ǰһ������
        int[] arr = {5,2,4,1,9};
        int temp;
        for(int i = 0;i<arr.length;i++)
            for (int j = 1;j<arr.length;j++){
                if(arr[j-1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] =temp;
                }
        }
//        System.out.println(Arrays.toString(arr));

        //ѡ�����򣬱�֤ÿ��ѭ��ѡ������һ����
        int[] arr1 = {5,2,4,1,9};
        int temp1;
        for(int i = 0;i<arr1.length-1;i++)
            for (int j = i+1;j<arr1.length;j++){
                if(arr1[i]>arr1[j]){
                   temp1 = arr1[i];
                   arr1[i] = arr1[j];
                   arr1[j] = temp1;
                }

            }
//        System.out.println(Arrays.toString(arr1));


        int[] arr2 = {7,2,5,4,1};
        quickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr2));

    }


    public static void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){
            //�Ӻ���ǰ�Ƚ�
            while(end>start&&a[end]>=key)  //  ���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //��ǰ����Ƚ�
            while(end>start&&a[start]<=key)//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
        }
        //�ݹ�
        if(start>low) sort(a,low,start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
        if(end<high) sort(a,end+1,high);//�ұ����С��ӹؼ�ֵ����+1�����һ��
    }


    public static void quickSort(int[] a,int left,int right){
       int i,j,t,temp;
       if(left>right)
           return ;

       temp = a[left];
       i = left;
       j = right;

       while(i!=j){
           while(a[j]<=temp&&i<j)//�ȴ��ұ�������
               j--;
           while(a[i]>=temp&&i<j)//�ٴ���������
               i++;
           if(i<j){
               t = a[i];
               a[i] = a[j];
               a[j] = t;
           }
       }
        a[left]=a[i];//i==j
        a[i] = temp;

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }
}

