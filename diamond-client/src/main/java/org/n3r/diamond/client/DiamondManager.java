package org.n3r.diamond.client;

import org.n3r.diamond.client.impl.Constants;
import org.n3r.diamond.client.impl.DiamondSubscriber;
import org.n3r.diamond.client.impl.DiamondSubstituter;

public class DiamondManager {
    private DiamondSubscriber diamondSubscriber = DiamondSubscriber.getInstance();

    private final DiamondStone.DiamondAxis diamondAxis;
    private int timeoutMillis = 1000;  // 从网络获取配置信息的超时，单位毫秒

    public DiamondManager(String dataId) {
        this(Constants.DEFAULT_GROUP, dataId);
    }

    public DiamondManager(String group, String dataId) {
        diamondAxis = DiamondStone.DiamondAxis.makeAxis(group, dataId);

        diamondSubscriber.getCacheData(diamondAxis);
    }

    public void addDiamondListener(DiamondListener diamondListener) {
        diamondSubscriber.addDiamondListener(diamondAxis, diamondListener);
    }

    public void removeDiamondListener(DiamondListener diamondListener) {
        diamondSubscriber.removeDiamondListener(diamondAxis, diamondListener);
    }

    public String getDiamond() {
        return diamondSubscriber.getDiamond(diamondAxis, timeoutMillis);
    }

    public Object getCache() {
        return diamondSubscriber.getCache(diamondAxis, timeoutMillis);
    }

}
