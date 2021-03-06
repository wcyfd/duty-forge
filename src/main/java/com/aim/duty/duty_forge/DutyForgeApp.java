package com.aim.duty.duty_forge;

import com.aim.duty.duty_base.cache.config.ConfigCache;
import com.aim.duty.duty_base.entity.bo.Furnace;
import com.aim.duty.duty_forge.cache.ConstantCache;
import com.aim.duty.duty_forge.cache.PropCache;
import com.aim.duty.duty_forge.schedule.ForgeScheduled;
import com.aim.duty.duty_forge.service.FurnaceService;
import com.aim.duty.duty_forge.service.FurnaceServiceImpl;
import com.aim.duty.duty_forge.service.FurnaceServiceImplProxy;
import com.aim.duty.duty_forge.ui.MainFrame;

/**
 * Hello world!
 *
 */
public class DutyForgeApp {
	public static void main(String[] args) {
		ConstantCache.init();
		PropCache.init();
		ConfigCache.init();

		Furnace forge = new Furnace();
		FurnaceService impl = new FurnaceServiceImplProxy(new FurnaceServiceImpl());		

		ConstantCache.forge = forge;
		ConstantCache.service = impl;

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ConstantCache.mainFrame = new MainFrame();
				ConstantCache.mainFrame.setVisible(true);
				ForgeScheduled.start();
			}
		});
	}
}
