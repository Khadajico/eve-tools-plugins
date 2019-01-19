/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 0.8.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arrggh.eve.esi.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * label object
 */
@ApiModel(description = "label object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class PostCharactersCharacterIdMailLabelsLabel {
  /**
   * Hexadecimal string representing label color, in RGB format
   */
  @JsonAdapter(ColorEnum.Adapter.class)
  public enum ColorEnum {
    _0000FE("#0000fe"),
    
    _006634("#006634"),
    
    _0099FF("#0099ff"),
    
    _00FF33("#00ff33"),
    
    _01FFFF("#01ffff"),
    
    _349800("#349800"),
    
    _660066("#660066"),
    
    _666666("#666666"),
    
    _999999("#999999"),
    
    _99FFFF("#99ffff"),
    
    _9A0000("#9a0000"),
    
    CCFF9A("#ccff9a"),
    
    E6E6E6("#e6e6e6"),
    
    FE0000("#fe0000"),
    
    FF6600("#ff6600"),
    
    FFFF01("#ffff01"),
    
    FFFFCD("#ffffcd"),
    
    FFFFFF("#ffffff");

    private String value;

    ColorEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ColorEnum fromValue(String text) {
      for (ColorEnum b : ColorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ColorEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ColorEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ColorEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ColorEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("color")
  private ColorEnum color = ColorEnum.FFFFFF;

  @SerializedName("name")
  private String name = null;

  public PostCharactersCharacterIdMailLabelsLabel color(ColorEnum color) {
    this.color = color;
    return this;
  }

   /**
   * Hexadecimal string representing label color, in RGB format
   * @return color
  **/
  @ApiModelProperty(value = "Hexadecimal string representing label color, in RGB format")
  public ColorEnum getColor() {
    return color;
  }

  public void setColor(ColorEnum color) {
    this.color = color;
  }

  public PostCharactersCharacterIdMailLabelsLabel name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name string
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name string")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostCharactersCharacterIdMailLabelsLabel postCharactersCharacterIdMailLabelsLabel = (PostCharactersCharacterIdMailLabelsLabel) o;
    return Objects.equals(this.color, postCharactersCharacterIdMailLabelsLabel.color) &&
        Objects.equals(this.name, postCharactersCharacterIdMailLabelsLabel.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostCharactersCharacterIdMailLabelsLabel {\n");
    
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

