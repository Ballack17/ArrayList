package lesson5.hw5;

public class BackPack {
    int []box;
    int totalValue;
    int totalWeight;
    int capWeight;
    int position;

    public BackPack(int boxQuantity,int capWeight) {
        box = new int[boxQuantity];
        for (int i = 0; i < boxQuantity; i++) {
            box[i] = -1;
        }
        this.totalValue = 0;
        this.totalWeight = 0;
        this.capWeight = capWeight;
        this.position = 0;
    }

    public void addBox(Box box,int index){
        this.box[position] = index;
        totalValue += box.getValue();
        totalWeight += box.getWeight();
        while (this.box[position] >=0 && position < this.box.length - 1) {position++;}
    }

    public void removeBox(Box[] box, int index){
        this.totalValue -= box[this.box[index]].getValue();
        this.totalWeight -= box[this.box[index]].getWeight();
        this.box[index] = -1;
        position = index;
    }


    public int getBox(int i) {
        return box[i];
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public int getCapWeight() {
        return capWeight;
    }

    public int getPosition(){
        return position;
    }

    @Override
    public String toString() {
        return
                "{ totalValue=" + totalValue +
                ", totalWeight=" + totalWeight +
                ", capWeight=" + capWeight +
                " }";
    }
     public void viewBoxes(Box[] box, int[] indexes){
         for (int i = 0; i < this.box.length;i++) {
             if (this.box[i] >= 0) {
                 System.out.println(box[indexes[this.box[i]+1]]);
             } else break;
         }
     }

    public BackPack fillTheBackPack(Box[] box, int[] sortedBox, BackPack bpBest, int removeQuantity) {
        int temp = 0;
        for (int i = 1; i < sortedBox.length; i++) {
            if ((box[sortedBox[i]].getWeight() + this.totalWeight) <= this.capWeight && !box[sortedBox[i]].isUsed()) {
                this.addBox(box[sortedBox[i]],sortedBox[i]);
                box[sortedBox[i]].setUsed(true);
            }
        }
        System.out.println("что там получается в новом варианте?");
        this.viewBoxes(box, sortedBox);
        System.out.println(this);
        System.out.println("\n");
        System.out.println("текущий лучший");
        bpBest.viewBoxes(box, sortedBox);
        System.out.println(bpBest);
        System.out.println("\n");
        if (this.totalValue > bpBest.totalValue) {
            bpBest.box = this.box;
            bpBest.totalValue = this.totalValue;
            bpBest.totalWeight = this.totalWeight;
            bpBest.position = this.position;
            System.out.println("обновление лучший");
            bpBest.viewBoxes(box, sortedBox);
            System.out.println(bpBest);
            System.out.println("\n");
        }
        if (this.capWeight - this.totalWeight > 0 && box[box.length -1].isUsed() ) {
            this.removeBox(box,this.position-1);
            this.fillTheBackPack(box,sortedBox,bpBest,removeQuantity);
        } else if (this.capWeight - this.totalWeight > 0 && !box[box.length -1].isUsed() && this.position > removeQuantity) {
            for (int i = 0; i < removeQuantity; i++) {
                temp = this.box[position -1];
                this.removeBox(box,this.position - 1);
            }
            removeQuantity++;
            for (int i = temp; i < sortedBox.length; i++) {
                box[sortedBox[i]].setUsed(false);
            }
            this.fillTheBackPack(box,sortedBox,bpBest,removeQuantity);
        }
        return bpBest;
    }
}
