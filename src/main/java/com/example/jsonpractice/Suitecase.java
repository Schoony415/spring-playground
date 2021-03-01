package com.example.jsonpractice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Suitcase {
    private final int width;
    private final int height;
    private final int depth;
    private final int weight;
    private String description;

    @JsonCreator
    Suitcase(
            @JsonProperty("width") int width,
            @JsonProperty("height") int height,
            @JsonProperty("depth") int depth,
            @JsonProperty("weight") int weight
    ) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.weight = weight;
        this.description="";
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public int getDepth() { return depth; }

    @JsonProperty("the-weight")
    public int getWeight() {
        return weight;
    }
    @JsonProperty("DESCRIPTION")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}