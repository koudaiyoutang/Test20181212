package com.example.springboot.model;

import javax.validation.constraints.NotNull;

public class TvCharacterVo {
  private Integer id;
  private int tvSeriesId;
  @NotNull
  private String name;

  public TvCharacterVo() {
  }

  public TvCharacterVo(Integer id, int tvSeriesId, String name) {
    this.id = id;
    this.tvSeriesId = tvSeriesId;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public int getTvSeriesId() {
    return tvSeriesId;
  }

  public String getName() {
    return name;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTvSeriesId(int tvSeriesId) {
    this.tvSeriesId = tvSeriesId;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "TvCharacterVo{" +
        "id=" + id +
        ", tvSeriesId=" + tvSeriesId +
        ", name='" + name + '\'' +
        '}';
  }
}
