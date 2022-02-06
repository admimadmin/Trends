/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Trend;

/**
 *
 * @author macmini
 */
class TrendDao {

    protected TrendDaoImpl trendDaoImpl;

    public TrendDao() {
        trendDaoImpl = new TrendDaoImpl("relational_shema");
    }

    protected void createTrend(Trend t) {
        trendDaoImpl.createTrend(t);
    }

    public void deleteTrend(Trend t) {
        trendDaoImpl.deleteTrend(t);
    }

    public void updateTrend(Trend t) {
        trendDaoImpl.updateTrend(t);
    }

    public void listTrend() {
        trendDaoImpl.listTrends();
    }

    public void findCity(Trend t){
        trendDaoImpl.findTrend(t);
    }
}
