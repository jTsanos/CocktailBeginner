package com.sisixa.cocktailbeginner;

public class Cocktail {
String name;
String ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6;
String measure1,measure2,measure3,measure4,measure5,measure6;
String image;
    public Cocktail() {
    }


    public Cocktail(String name, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6, String measure1, String measure2, String measure3, String measure4, String measure5, String measure6,String image ) {
        this.name = name;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
        this.measure1 = measure1;
        this.measure2 = measure2;
        this.measure3 = measure3;
        this.measure4 = measure4;
        this.measure5 = measure5;
        this.measure6 = measure6;
        this.image=image;

    }

    public String getName() {
        return name;
    }

    public String getIngredient1() {
        return ingredient1;

        }



    public String getIngredient2() {
        return ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public String getIngredient5() {
        return ingredient5;
    }

    public String getIngredient6() {
        return ingredient6;
    }

    public String getMeasure1() {
        return measure1;
    }

    public String getMeasure2() {
        return measure2;
    }

    public String getMeasure3() {
        return measure3;
    }

    public String getMeasure4() {
        return measure4;
    }

    public String getMeasure5() {
        return measure5;
    }

    public String getMeasure6() {
        return measure6;
    }

    public String getImage() {
        return image;
    }
}
