package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import Statistics.ARPACommon;

public class MainRoot {
	
	public MainRoot() {
	}
	
	public void DoingStatistics(String processdir)
	{
		// only support file
		ARPACommon.CountOneFile(new File(processdir));
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String cmd = null;
			System.out.println("Please input statistics command:");
			while ((cmd = br.readLine()) != null)
			{
				if (cmd.startsWith("start "))
				{
					System.out.println("start running.");
					String processdir = cmd.substring("start ".length(), cmd.length());
					MainRoot mr = new MainRoot();
					mr.DoingStatistics(processdir);
				}
				if (cmd.equals("stop"))
				{
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}