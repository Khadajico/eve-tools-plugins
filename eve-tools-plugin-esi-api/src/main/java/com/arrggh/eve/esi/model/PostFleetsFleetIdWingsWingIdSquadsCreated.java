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
 * 201 created object
 */
@ApiModel(description = "201 created object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class PostFleetsFleetIdWingsWingIdSquadsCreated {
  @SerializedName("squad_id")
  private Long squadId = null;

  public PostFleetsFleetIdWingsWingIdSquadsCreated squadId(Long squadId) {
    this.squadId = squadId;
    return this;
  }

   /**
   * The squad_id of the newly created squad
   * @return squadId
  **/
  @ApiModelProperty(required = true, value = "The squad_id of the newly created squad")
  public Long getSquadId() {
    return squadId;
  }

  public void setSquadId(Long squadId) {
    this.squadId = squadId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostFleetsFleetIdWingsWingIdSquadsCreated postFleetsFleetIdWingsWingIdSquadsCreated = (PostFleetsFleetIdWingsWingIdSquadsCreated) o;
    return Objects.equals(this.squadId, postFleetsFleetIdWingsWingIdSquadsCreated.squadId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(squadId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostFleetsFleetIdWingsWingIdSquadsCreated {\n");
    
    sb.append("    squadId: ").append(toIndentedString(squadId)).append("\n");
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

