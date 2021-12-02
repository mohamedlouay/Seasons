package seasons.des;

import seasons.des.faces.face;

import java.util.Random;

public class des {
    public String color;

    Random random = new Random();

    face[] faces;
    public des(face[] faces,String color){
        this.color=color;

        this.faces=faces;


    }

    public void setRandom(Random r){
        this.random=r;
    }


    public face getRandomFace(){

        int value = random.nextInt(6);
        return faces[value];

    }

    public face[] getFaces() {
        return faces;
    }
}
