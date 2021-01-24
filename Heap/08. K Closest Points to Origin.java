/*
Company Tags: Amazon
Practice Portal:
LeetCode: https://leetcode.com/problems/k-closest-points-to-origin/
*/

/****************************************** Using PriorityQueue (LeetCode) ********************************************/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        PriorityQueue<Points> maxHeap = new PriorityQueue<>(K, new Comparator<Points>() {
            public int compare(Points a, Points b){
                return  ((b.pointA*b.pointA)+(b.pointB*b.pointB)) - ((a.pointA*a.pointA)+(a.pointB*a.pointB));
            }
        });

        for (int i=0; i<points.length; i++) {
            int[] arr = points[i];
            Points point = new Points(arr[0],arr[1]);
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        for(int j=0;j<K;j++){
            Points c = maxHeap.remove();
            result[j][0] = c.pointA;
            result[j][1] = c.pointB;
        }

        return result;
    }
}

class Points{
    int pointA;
    int pointB;
    Points(int a,int b){
        pointA = a;
        pointB = b;
    }
}

/****************************************** Using HEAP (LeetCode) ********************************************/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        MaxHeap maxHeap = new MaxHeap(10000);

        for (int i=0; i<K; i++) {
            Pair point = new Pair(points[i][0], points[i][1]);
            insertInMaxHeap(point, maxHeap);
        }

        for (int i=K; i<points.length; i++) {
            Pair point = new Pair(points[i][0], points[i][1]);
            if (getEuclideanDistancefromOrigin(getMaxHeapTop(maxHeap)) > getEuclideanDistancefromOrigin(point)) {
                maxHeap.heap[0] = point;
                maxHeapify(maxHeap, 0);
            }
        }

        int[][] nearestKPoints = new int[K][2];
        int index=0;
        while (maxHeap.currSize > 0) {
            Pair point = removeTopFromHeap(maxHeap);
            nearestKPoints[index][0] = (int)point.getKey();
            nearestKPoints[index][1] = (int)point.getValue();
            index++;
        }

        return nearestKPoints;
    }

    double getEuclideanDistancefromOrigin(Pair points) {
        int x = (int)points.getKey();
        int y = (int)points.getValue();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); //Formula is Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2))
    }

    class MaxHeap {
        Pair[] heap;
        int currSize;
        int maxSize;

        MaxHeap(int maxSize) {
            this.heap = new Pair[maxSize];
            this.currSize = 0;
            this.maxSize = maxSize;
        }
    }

    int getParent(int index) {
        return (index-1)/2;
    }

    int getLeftChild(int index) {
        return 2*index + 1;
    }

    int getRightChild(int index) {
        return 2*index + 2;
    }

    Pair getMaxHeapTop(MaxHeap maxHeap) {
        return maxHeap.heap[0];
    }

    void insertInMaxHeap(Pair points, MaxHeap maxHeap) {
        maxHeap.heap[maxHeap.currSize] = points;
        int currentHeapIndex = maxHeap.currSize;

        while (getEuclideanDistancefromOrigin(maxHeap.heap[currentHeapIndex]) > getEuclideanDistancefromOrigin(maxHeap.heap[getParent(currentHeapIndex)])) {
            swapElements(maxHeap, currentHeapIndex, getParent(currentHeapIndex));
            currentHeapIndex = getParent(currentHeapIndex);
        }

        maxHeap.currSize++;
    }

    void maxHeapify(MaxHeap maxHeap, int index) {
        int largestIndex = index;
        int leftIndex = getLeftChild(index);
        int rightIndex = getRightChild(index);


        if (leftIndex < maxHeap.currSize && getEuclideanDistancefromOrigin(maxHeap.heap[leftIndex]) > getEuclideanDistancefromOrigin(maxHeap.heap[largestIndex]))
            largestIndex = leftIndex;

        if (rightIndex < maxHeap.currSize && getEuclideanDistancefromOrigin(maxHeap.heap[rightIndex]) > getEuclideanDistancefromOrigin(maxHeap.heap[largestIndex]))
            largestIndex = rightIndex;

        if (largestIndex != index)
        {
            swapElements(maxHeap, index, largestIndex);
            maxHeapify(maxHeap, largestIndex);
        }
    }

    Pair removeTopFromHeap(MaxHeap maxHeap) {
        Pair point = maxHeap.heap[0];
        maxHeap.heap[0] = maxHeap.heap[--maxHeap.currSize];
        maxHeapify(maxHeap, 0);
        return point;
    }

    void swapElements(MaxHeap maxHeap, int index1, int index2) {
        Pair temp = maxHeap.heap[index1];
        maxHeap.heap[index1] = maxHeap.heap[index2];
        maxHeap.heap[index2] = temp;
    }
}