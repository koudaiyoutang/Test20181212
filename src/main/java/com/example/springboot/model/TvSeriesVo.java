package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class TvSeriesVo {

  @Null
  private Integer id;
  @NotNull
  @NotEmpty( message = "name不能为空")
  private String name;
  @DecimalMin(value = "1" ,message = "电视集数大于或者等于1")
  private int seasonCount;
  @Past
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
  private Date originRelease;
 // @NotNull
 // @Size(min = 2)
 // @Valid
  private List<TvCharacterVo> tvCharacters;

  public TvSeriesVo() {
  }

  public TvSeriesVo(@Null Integer id, @NotNull String name,
      @DecimalMin("1") int seasonCount,
      @Past Date originRelease) {
    this.id = id;
    this.name = name;
    this.seasonCount = seasonCount;
    this.originRelease = originRelease;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getSeasonCount() {
    return seasonCount;
  }

  public List<TvCharacterVo> getTvCharacters() {
    return tvCharacters;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSeasonCount(int seasonCount) {
    this.seasonCount = seasonCount;
  }


  public void setTvCharacters(List<TvCharacterVo> tvCharacters) {
    this.tvCharacters = tvCharacters;
  }

  public Date getOriginRelease() {
    return originRelease;
  }

  public void setOriginRelease(Date originRelease) {
    this.originRelease = originRelease;
  }

  @Override
  public String toString() {
    return "TvSeriesVo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", seasonCount=" + seasonCount +
        ", originRelease=" + originRelease +
        ", tvCharacters=" + tvCharacters +
        '}';
  }
}
