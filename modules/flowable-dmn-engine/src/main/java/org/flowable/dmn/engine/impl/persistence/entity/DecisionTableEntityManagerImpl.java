/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.dmn.engine.impl.persistence.entity;

import java.util.List;
import java.util.Map;

import org.flowable.common.engine.impl.persistence.entity.data.DataManager;
import org.flowable.dmn.api.DmnDecisionTable;
import org.flowable.dmn.engine.DmnEngineConfiguration;
import org.flowable.dmn.engine.impl.DecisionTableQueryImpl;
import org.flowable.dmn.engine.impl.persistence.entity.data.DecisionTableDataManager;

/**
 * @author Tijs Rademakers
 * @author Joram Barrez
 */
public class DecisionTableEntityManagerImpl extends AbstractEntityManager<DecisionTableEntity> implements DecisionTableEntityManager {

    protected DecisionTableDataManager decisionTableDataManager;

    public DecisionTableEntityManagerImpl(DmnEngineConfiguration dmnEngineConfiguration, DecisionTableDataManager decisionTableDataManager) {
        super(dmnEngineConfiguration);
        this.decisionTableDataManager = decisionTableDataManager;
    }

    @Override
    protected DataManager<DecisionTableEntity> getDataManager() {
        return decisionTableDataManager;
    }

    @Override
    public DecisionTableEntity findLatestDecisionTableByKey(String decisionTableKey) {
        return decisionTableDataManager.findLatestDecisionTableByKey(decisionTableKey);
    }

    @Override
    public DecisionTableEntity findLatestDecisionTableByKeyAndTenantId(String decisionTableKey, String tenantId) {
        return decisionTableDataManager.findLatestDecisionTableByKeyAndTenantId(decisionTableKey, tenantId);
    }

    @Override
    public void deleteDecisionTablesByDeploymentId(String deploymentId) {
        decisionTableDataManager.deleteDecisionTablesByDeploymentId(deploymentId);
    }

    @Override
    public List<DmnDecisionTable> findDecisionTablesByQueryCriteria(DecisionTableQueryImpl decisionTableQuery) {
        return decisionTableDataManager.findDecisionTablesByQueryCriteria(decisionTableQuery);
    }

    @Override
    public long findDecisionTableCountByQueryCriteria(DecisionTableQueryImpl decisionTableQuery) {
        return decisionTableDataManager.findDecisionTableCountByQueryCriteria(decisionTableQuery);
    }

    @Override
    public DecisionTableEntity findDecisionTableByDeploymentAndKey(String deploymentId, String decisionTableKey) {
        return decisionTableDataManager.findDecisionTableByDeploymentAndKey(deploymentId, decisionTableKey);
    }

    @Override
    public DecisionTableEntity findDecisionTableByDeploymentAndKeyAndTenantId(String deploymentId, String decisionTableKey, String tenantId) {
        return decisionTableDataManager.findDecisionTableByDeploymentAndKeyAndTenantId(deploymentId, decisionTableKey, tenantId);
    }

    @Override
    public DecisionTableEntity findDecisionTableByKeyAndVersionAndTenantId(String decisionTableKey, Integer decisionTableVersion, String tenantId) {
        if (tenantId == null || DmnEngineConfiguration.NO_TENANT_ID.equals(tenantId)) {
            return decisionTableDataManager.findDecisionTableByKeyAndVersion(decisionTableKey, decisionTableVersion);
        } else {
            return decisionTableDataManager.findDecisionTableByKeyAndVersionAndTenantId(decisionTableKey, decisionTableVersion, tenantId);
        }
    }

    @Override
    public List<DmnDecisionTable> findDecisionTablesByNativeQuery(Map<String, Object> parameterMap) {
        return decisionTableDataManager.findDecisionTablesByNativeQuery(parameterMap);
    }

    @Override
    public long findDecisionTableCountByNativeQuery(Map<String, Object> parameterMap) {
        return decisionTableDataManager.findDecisionTableCountByNativeQuery(parameterMap);
    }

    @Override
    public void updateDecisionTableTenantIdForDeployment(String deploymentId, String newTenantId) {
        decisionTableDataManager.updateDecisionTableTenantIdForDeployment(deploymentId, newTenantId);
    }

    public DecisionTableDataManager getDecisionTableDataManager() {
        return decisionTableDataManager;
    }

    public void setDecisionTableDataManager(DecisionTableDataManager decisionTableDataManager) {
        this.decisionTableDataManager = decisionTableDataManager;
    }

}
