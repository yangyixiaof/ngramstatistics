package Statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ARPACommon {
	
	public static void CountOneFile(File f)
	{
		Map<Integer, Integer> statis = new TreeMap<Integer, Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String oneline = null;
			int line = 0;
			int allline = 0;
			while ((oneline = br.readLine()) != null)
			{
				allline++;
				oneline = oneline.trim();
				String[] ss = oneline.split(" |	");
				
				//System.out.println("content:"+oneline + ";sslength:"+ss.length);
				/*System.err.println(ss.length);
				for (int i=0;i<ss.length;i++)
				{
					System.err.println(ss[i]);
				}*/
				
				if (ss.length == 4)
				{
					line++;
					System.out.println("current aline:"+allline + ";line:"+line+";content:"+oneline);
					AddCount(statis, Integer.parseInt(ss[ss.length-1]), 1);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintCounts(statis);
	}
	
	private static void PrintCounts(Map<Integer, Integer> statis)
	{
		Set<Integer> keys = statis.keySet();
		Iterator<Integer> itr = keys.iterator();
		while (itr.hasNext())
		{
			Integer occurtime = itr.next();
			Integer corrcount = statis.get(occurtime);
			System.out.println("3-gram occurtime:"+occurtime+";corrcount:"+corrcount);
		}
	}
	
	private static void AddCount(Map<Integer, Integer> statis, int occurtimes, int correscount)
	{
		Integer ccount = statis.get(occurtimes);
		if (ccount == null)
		{
			ccount = 0;
		}
		ccount += correscount;
		statis.put(occurtimes, ccount);
	}
	
}