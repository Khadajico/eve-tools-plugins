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
 * inventory object
 */
@ApiModel(description = "inventory object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class GetCharactersCharacterIdStatsInventory {
  @SerializedName("abandon_loot_quantity")
  private Long abandonLootQuantity = null;

  @SerializedName("trash_item_quantity")
  private Long trashItemQuantity = null;

  public GetCharactersCharacterIdStatsInventory abandonLootQuantity(Long abandonLootQuantity) {
    this.abandonLootQuantity = abandonLootQuantity;
    return this;
  }

   /**
   * abandon_loot_quantity integer
   * @return abandonLootQuantity
  **/
  @ApiModelProperty(value = "abandon_loot_quantity integer")
  public Long getAbandonLootQuantity() {
    return abandonLootQuantity;
  }

  public void setAbandonLootQuantity(Long abandonLootQuantity) {
    this.abandonLootQuantity = abandonLootQuantity;
  }

  public GetCharactersCharacterIdStatsInventory trashItemQuantity(Long trashItemQuantity) {
    this.trashItemQuantity = trashItemQuantity;
    return this;
  }

   /**
   * trash_item_quantity integer
   * @return trashItemQuantity
  **/
  @ApiModelProperty(value = "trash_item_quantity integer")
  public Long getTrashItemQuantity() {
    return trashItemQuantity;
  }

  public void setTrashItemQuantity(Long trashItemQuantity) {
    this.trashItemQuantity = trashItemQuantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdStatsInventory getCharactersCharacterIdStatsInventory = (GetCharactersCharacterIdStatsInventory) o;
    return Objects.equals(this.abandonLootQuantity, getCharactersCharacterIdStatsInventory.abandonLootQuantity) &&
        Objects.equals(this.trashItemQuantity, getCharactersCharacterIdStatsInventory.trashItemQuantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abandonLootQuantity, trashItemQuantity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdStatsInventory {\n");
    
    sb.append("    abandonLootQuantity: ").append(toIndentedString(abandonLootQuantity)).append("\n");
    sb.append("    trashItemQuantity: ").append(toIndentedString(trashItemQuantity)).append("\n");
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
