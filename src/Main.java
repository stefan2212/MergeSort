class MergeSort{
    private int [] array;
    private int size;
    MergeSort(int size){
        this.size=size;
        array =  new int[size];
        generateRandomArray();
    }

    private void generateRandomArray(){
        for(int i=0;i<size;i++)
            array[i] = (int)(Math.random()*10)+10;
    }

    public void display(){
        for(int i=0;i<size;i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void mergeSort(int low,int high){
        if(low<high)
        {
            int midle =low + (high - low)/2;
            mergeSort(low,midle);
            mergeSort(midle+1,high);
            merge(low,midle,high);
        }
    }

    private void merge(int low,int midle,int high){
        int [] newArray = new int [10];
        for(int it=low;it<=high;it++)
        {
            newArray[it]=array[it];
        }
        int i = low;
        int j=midle+1;
        int k=low;

        while(i<=midle && j<=high){
            if(newArray[i] <= newArray[j])
            {
                array[k]=newArray[i];
                i++;
            }
            else{
                array[k]=newArray[j];
                j++;
            }
            k++;
        }
        while(i<=midle)
        {
            array[k]=newArray[i];
            i++;
            k++;
        }
        while(j<=high)
        {
            array[k]=newArray[j];
            j++;
            k++;
        }

    }
}

public class Main {

    public static void main(String[] args) {
        MergeSort merge =new MergeSort(10);
        merge.display();
        merge.mergeSort(0,9);
        merge.display();
    }
}
