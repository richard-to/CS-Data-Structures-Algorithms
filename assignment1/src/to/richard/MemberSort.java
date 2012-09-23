package to.richard;

import java.util.Comparator;

public class MemberSort {

    /**
     * Sorts list of members
     *
     * Merge sort is used to sort members internally.
     *
     * @param list    Member list to sort by
     * @param compare Comparator class to decide where field to sort by
     *
     * @return Sorted linked list
     */
    public LinkedList<Member> sort(LinkedList<Member> list, Comparator<Member> compare){
        Member[] members = new Member[list.size()];
        int index = 0;
        LinkedListIter<Member> iter = list.iterator();
        while(iter.hasNext()){
            members[index] = iter.next();
            index++;
        }

        Member[] sortedMembers = merge_sort(members, compare);
        int size = sortedMembers.length;
        LinkedList<Member> sortedList = new LinkedList<Member>();
        for(int i = 0; i < size; i++)
            sortedList.addLast(sortedMembers[i]);
        return sortedList;
    }

    private Member[] merge_sort(Member[] members, Comparator<Member> compare){

        int size = members.length;

        if(size <= 1){
            return members;
        }

        int middle = size / 2;
        int leftSize = middle;
        int rightSize = size - middle;

        Member[] left = new Member[leftSize];
        Member[] right = new Member[rightSize];

        for(int i = 0; i < leftSize; i++)
            left[i] = members[i];

        for(int i = 0; i < rightSize; i++)
            right[i] = members[middle + i];

        left = merge_sort(left, compare);
        right = merge_sort(right, compare);

        return merge(left, right, compare);
    }

    private Member[] merge(Member[] left, Member[] right, Comparator<Member> compare){
        int leftSize = left.length;
        int rightSize = right.length;
        Member[] result = new Member[leftSize + rightSize];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while(leftIndex < leftSize && rightIndex < rightSize){
            if(compare.compare(left[leftIndex], right[rightIndex]) >= 0)
                result[resultIndex++] = left[leftIndex++];
            else
                result[resultIndex++] = right[rightIndex++];
        }

        while(leftIndex < leftSize)
            result[resultIndex++] = left[leftIndex++];

        while(rightIndex < rightSize)
            result[resultIndex++] = right[rightIndex++];

        return result;
    }
}
