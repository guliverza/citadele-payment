package com.guliverza;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Payment {

    @NotBlank(message = "Title cannot be blank")
    public String title;

    @NotBlank(message = "Author cannot be blank")
    public String author;

    @Min(message = "Author has been very lazy", value = 1)
    public double pages;
}
