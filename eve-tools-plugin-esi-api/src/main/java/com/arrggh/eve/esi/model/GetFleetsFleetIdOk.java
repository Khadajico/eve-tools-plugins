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
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class GetFleetsFleetIdOk {
  @SerializedName("is_free_move")
  private Boolean isFreeMove = null;

  @SerializedName("is_registered")
  private Boolean isRegistered = null;

  @SerializedName("is_voice_enabled")
  private Boolean isVoiceEnabled = null;

  @SerializedName("motd")
  private String motd = null;

  public GetFleetsFleetIdOk isFreeMove(Boolean isFreeMove) {
    this.isFreeMove = isFreeMove;
    return this;
  }

   /**
   * Is free-move enabled
   * @return isFreeMove
  **/
  @ApiModelProperty(required = true, value = "Is free-move enabled")
  public Boolean isIsFreeMove() {
    return isFreeMove;
  }

  public void setIsFreeMove(Boolean isFreeMove) {
    this.isFreeMove = isFreeMove;
  }

  public GetFleetsFleetIdOk isRegistered(Boolean isRegistered) {
    this.isRegistered = isRegistered;
    return this;
  }

   /**
   * Does the fleet have an active fleet advertisement
   * @return isRegistered
  **/
  @ApiModelProperty(required = true, value = "Does the fleet have an active fleet advertisement")
  public Boolean isIsRegistered() {
    return isRegistered;
  }

  public void setIsRegistered(Boolean isRegistered) {
    this.isRegistered = isRegistered;
  }

  public GetFleetsFleetIdOk isVoiceEnabled(Boolean isVoiceEnabled) {
    this.isVoiceEnabled = isVoiceEnabled;
    return this;
  }

   /**
   * Is EVE Voice enabled
   * @return isVoiceEnabled
  **/
  @ApiModelProperty(required = true, value = "Is EVE Voice enabled")
  public Boolean isIsVoiceEnabled() {
    return isVoiceEnabled;
  }

  public void setIsVoiceEnabled(Boolean isVoiceEnabled) {
    this.isVoiceEnabled = isVoiceEnabled;
  }

  public GetFleetsFleetIdOk motd(String motd) {
    this.motd = motd;
    return this;
  }

   /**
   * Fleet MOTD in CCP flavoured HTML
   * @return motd
  **/
  @ApiModelProperty(required = true, value = "Fleet MOTD in CCP flavoured HTML")
  public String getMotd() {
    return motd;
  }

  public void setMotd(String motd) {
    this.motd = motd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFleetsFleetIdOk getFleetsFleetIdOk = (GetFleetsFleetIdOk) o;
    return Objects.equals(this.isFreeMove, getFleetsFleetIdOk.isFreeMove) &&
        Objects.equals(this.isRegistered, getFleetsFleetIdOk.isRegistered) &&
        Objects.equals(this.isVoiceEnabled, getFleetsFleetIdOk.isVoiceEnabled) &&
        Objects.equals(this.motd, getFleetsFleetIdOk.motd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isFreeMove, isRegistered, isVoiceEnabled, motd);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFleetsFleetIdOk {\n");
    
    sb.append("    isFreeMove: ").append(toIndentedString(isFreeMove)).append("\n");
    sb.append("    isRegistered: ").append(toIndentedString(isRegistered)).append("\n");
    sb.append("    isVoiceEnabled: ").append(toIndentedString(isVoiceEnabled)).append("\n");
    sb.append("    motd: ").append(toIndentedString(motd)).append("\n");
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
