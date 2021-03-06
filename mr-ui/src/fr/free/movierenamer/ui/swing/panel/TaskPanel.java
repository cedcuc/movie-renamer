/*
 * Copyright (C) 2013 Nicolas Magré
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
package fr.free.movierenamer.ui.swing.panel;

import com.alee.laf.panel.WebPanel;
import com.alee.managers.tooltip.TooltipWay;
import fr.free.movierenamer.ui.utils.ImageUtils;
import fr.free.movierenamer.ui.utils.UIUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class TaskPanel
 *
 * @author Nicolas Magré
 */
public class TaskPanel extends WebPanel {

  private final ActionListener showpopup = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    }
  };

  public TaskPanel(String str) {
    this(str, true);
  }

  /**
   * Creates new form TaskPanel
   */
  public TaskPanel(String str, boolean indeterminate) {
    initComponents();
    progressBar.setIndeterminate(indeterminate);
    progressBar.setMinimum(0);
    progressBar.setMaximum(100);
    cancelBtn.addActionListener(showpopup);
    nameLbl.setText(str);
  }

  public void setProgress(int progress) {
    if (progress < 0 || progress > 100) {
      progressBar.setIndeterminate(true);
      return;
    }
    progressBar.setIndeterminate(false);
    progressBar.setValue(progress);
  }

  public void setStatus(String str) {
    statusLbl.setText(str);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    nameLbl = new com.alee.laf.label.WebLabel();
    progressBar = new com.alee.laf.progressbar.WebProgressBar();
    statusLbl = new com.alee.laf.label.WebLabel();
    cancelBtn = UIUtils.createButton("cancel", ImageUtils.CANCEL_8, ImageUtils.CANCEL_8, TooltipWay.up);

    setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    add(nameLbl);
    add(progressBar);
    add(statusLbl);

    cancelBtn.setIcon(ImageUtils.CANCEL_8);
    add(cancelBtn);
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private com.alee.laf.button.WebButton cancelBtn;
  private com.alee.laf.label.WebLabel nameLbl;
  private com.alee.laf.progressbar.WebProgressBar progressBar;
  private com.alee.laf.label.WebLabel statusLbl;
  // End of variables declaration//GEN-END:variables
}
