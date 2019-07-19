package cloud.monitor.client;

import org.hyperic.sigar.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class SystemSource {

    public static Map<String, String> getHost() throws UnknownHostException {
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        Map<String, String> map = System.getenv();

        Map<String, String> host = new HashMap<String, String>();
        host.put("userName", map.get("USERNAME"));
        host.put("computerName", map.get("COMPUTERNAME"));
        host.put("userDomain ", map.get("USERDOMAIN"));
        host.put("ip", addr.getHostAddress());
        host.put("hostName", addr.getHostName());
        return host;
    }

    public static List<Map<String, Object>> getCpu() throws SigarException {
        List<Map<String, Object>> cpuList = new ArrayList<Map<String, Object>>();

        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuPercs[] = null;
        cpuPercs = sigar.getCpuPercList();

        Map<String, Object> cpu = null;
        for (int i = 0; i < infos.length; i++) {
            cpu = new HashMap<String, Object>();
            CpuInfo info = infos[i];
            CpuPerc cpuPerc = cpuPercs[i];

            cpu.put("mhz", info.getMhz());
            cpu.put("cacheSize", info.getCacheSize());
            cpu.put("us", cpuPerc.getUser());
            cpu.put("sy", cpuPerc.getSys());
            cpu.put("wa", cpuPerc.getWait());
            cpu.put("ni", cpuPerc.getNice());
            cpu.put("id", cpuPerc.getIdle());
            cpu.put("combined", cpuPerc.getCombined());

            cpuList.add(cpu);
        }

        return cpuList;
    }

    public static Map<String, Object> getMemory() throws SigarException{
        Map<String, Object> memory = new HashMap<String, Object>();

        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();

        memory.put("total", mem.getTotal());
        memory.put("used", mem.getUsed());
        memory.put("free", mem.getFree());

        return memory;
    }

    public static Map<String, Object> getSwap() throws SigarException{
        Map<String, Object> swapMap = new HashMap<String, Object>();

        Sigar sigar = new Sigar();
        Swap swap = sigar.getSwap();

        swapMap.put("total", swap.getTotal());
        swapMap.put("used", swap.getUsed());
        swapMap.put("free", swap.getFree());

        return swapMap;
    }

    public static List<Map<String, Object>> getDisk() throws SigarException{
        List<Map<String, Object>> diskList = new ArrayList<Map<String, Object>>();

        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();

        Map<String, Object> disk = null;
        for (int i = 0; i < fslist.length; i++) {
            disk = new HashMap<String, Object>();
            FileSystem fs = fslist[i];
            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());

            disk.put("devName", fs.getDevName());
            disk.put("dirName", fs.getDirName());
            disk.put("sysTypeName", fs.getSysTypeName());

            if (usage != null && fs.getType() == 2) {
                disk.put("total", usage.getTotal());
                disk.put("free", usage.getFree());
                disk.put("avail", usage.getAvail());
                disk.put("used", usage.getUsed());
            }

            diskList.add(disk);
        }

        return diskList;
    }

    public static List<Map<String, Object>> getNetwork() throws SigarException{
        List<Map<String, Object>> netList = new ArrayList<Map<String, Object>>();

        Sigar sigar = new Sigar();
        String ifNames[] = sigar.getNetInterfaceList();

        Map<String, Object> net = null;
        for (int i = 0; i < ifNames.length; i++) {
            net = new HashMap<String, Object>();
            String name = ifNames[i];
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);

            net.put("name", name);
            net.put("address", ifconfig.getAddress());
            net.put("netmask", ifconfig.getNetmask());

            if ((ifconfig.getFlags() & 1L) <= 0L) {
                continue;
            }

            net.put("rxpackets", ifstat.getRxPackets());
            net.put("txpackets", ifstat.getTxPackets());
            net.put("rxbytes", ifstat.getRxBytes());
            net.put("txbytes", ifstat.getTxBytes());
            net.put("rxerrors", ifstat.getRxErrors());
            net.put("txerrors", ifstat.getTxErrors());
            net.put("rxdropped", ifstat.getRxDropped());
            net.put("txdropped", ifstat.getTxDropped());

            netList.add(net);
        }

        return netList;
    }

}
