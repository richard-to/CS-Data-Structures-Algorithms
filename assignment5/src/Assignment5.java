import to.richard.*;

public class Assignment5 {
    public static void main(String[] args){

        NumGen numGen = new NumGen();
        Integer[] randSeq = numGen.generate();

        LinearSearch<Integer> linearSearch = new LinearSearch<Integer>(randSeq);
        BinarySearch<Integer> binarySearch = new BinarySearch<Integer>(randSeq);
        BstSearch<Integer> bstSearch = new BstSearch<Integer>(randSeq);
        BstSearch<Integer> bstSortedSearch = new BstSearch<Integer>(binarySearch.getSequence());
        AvlSearch<Integer> avlSearch = new AvlSearch<Integer>(randSeq);

        CompMon<Integer> compMon = new CompMon<Integer>();
        getFindStats(compMon, linearSearch, "Linear Search");
        getFindStats(compMon, linearSearch, "Binary Search");
        getFindStats(compMon, binarySearch, "Bst Search");
        getFindStats(compMon, bstSortedSearch, "Bst Sorted Search");
        getFindStats(compMon, bstSortedSearch, "Avl Search");
    }

    public static void getFindStats(CompMon<Integer> compMon, Search<Integer> search, String label){
        System.out.println(label);
        System.out.println("=====================");
        compMon.setSearch(search);
        compMon.run();
        compMon.printResults();
        System.out.println();
    }
}
