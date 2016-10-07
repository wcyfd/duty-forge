package com.aim.duty.duty_forge;

import com.aim.duty.duty_forge.cache.ConstantCache;
import com.aim.duty.duty_forge.cache.PropCache;
import com.aim.duty.duty_forge.cache.config.ConfigCache;
import com.aim.duty.duty_forge.entity.Forge;
import com.aim.duty.duty_forge.schedule.ForgeScheduled;
import com.aim.duty.duty_forge.service.Service;
import com.aim.duty.duty_forge.service.ServiceImpl;
import com.aim.duty.duty_forge.service.ServiceImplProxy;
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

		Forge forge = new Forge();
		Service impl = new ServiceImplProxy(new ServiceImpl());

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