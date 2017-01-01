/*
 * movie-renamer-core
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
package fr.free.movierenamer.searchinfo;

import java.net.URL;

/**
 * Class Image
 *
 * @author Nicolas Magré
 * @author Simon QUÉMÉNEUR
 */
public class Image extends Hyperlink {

  private static final long serialVersionUID = 1L;

  protected Image() {
    // used by serializer
  }

  public Image(String name, URL image) {
    super(name, null, image);
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
