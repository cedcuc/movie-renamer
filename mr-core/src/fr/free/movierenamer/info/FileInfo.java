/*
 * mr-core
 * Copyright (C) 2012-2013 Nicolas Magré
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.free.movierenamer.info;

import fr.free.movierenamer.mediainfo.MediaTag;
import fr.free.movierenamer.namematcher.NameMatcher;
import fr.free.movierenamer.renamer.Renamer;
import fr.free.movierenamer.utils.FileUtils;
import fr.free.movierenamer.utils.ScrapperUtils;
import java.io.File;
import java.net.URI;
import java.util.Map;

/**
 * Class FileInfo
 *
 * @author Nicolas Magré
 * @author Simon QUÉMÉNEUR
 */
public class FileInfo extends Info {

  private static final long minMovieFileSize = 450000;
  private static final long serialVersionUID = 1L;
  private File file;
  private final MediaType type;
  private String search;
  private final Map<FileProperty, String> fileProperty;
  private final MediaTag mtag;

  public enum MediaType {

    MOVIE,
    TVSHOW
  }

  public enum FileProperty {

    name,
    year,
    season,
    episode,
    imdbId
  }

  public FileInfo(File file) {
    this.file = file;
    this.type = getMediaType(file);
    fileProperty = NameMatcher.getProperty(file, type);
    search = fileProperty.get(FileProperty.name);
    this.mtag = new MediaTag(file);
  }

  public IdInfo getImdbId() {
    String id = get(FileProperty.imdbId);
    if(id != null && id.length() > 0) {
      return new IdInfo(Integer.parseInt(id), ScrapperUtils.AvailableApiIds.IMDB);
    }
    return null;
  }

  public Integer getSeason() {
    try {
      return new Integer(get(FileProperty.season));
    } catch (Exception e) {
      return null;
    }
  }

  public Integer getEpisode() {
    try {
      return new Integer(get(FileProperty.episode));
    } catch (Exception e) {
      return null;
    }
  }

  public String get(FileProperty property) {
    return fileProperty.get(property);
  }

  private MediaType getMediaType(File file) {// TODO A refaire , améliorer la detection !!!
    String filename = file.getName();

    if (file.length() < minMovieFileSize) {
      return MediaType.TVSHOW;
    }

    return MediaType.MOVIE;
  }

  public String getSearch() {
    return search;
  }

  public Integer getYear() {
    try {
      return Integer.parseInt(fileProperty.get(FileProperty.year));
    } catch (Exception ex) {
      return -1;
    }
  }

  public boolean wasRenamed() {
    return Renamer.getInstance().wasRenamed(this);
  }

  public MediaType getType() {
    return type;
  }

  public MediaTag getMediaTag() {
    return mtag;
  }

  public final void setSearch(String search) {
    this.search = search;
  }

  public boolean renamed(String newName) {
    File newFile = FileUtils.move(this.file, newName);
    boolean success = Renamer.getInstance().addRenamed(this, this.file.toURI(), newFile.toURI());
    this.file = newFile;
    return success;
  }

  public URI getURI() {
    return this.file.toURI();
  }

  public File getFile() {
    return file;
  }
}
