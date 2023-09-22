/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.registry.client.migration;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.registry.client.migration.model.MigrationRule;
import org.apache.dubbo.registry.client.migration.model.MigrationStep;
import org.apache.dubbo.rpc.cluster.ClusterInvoker;

/**
 * FIXME, some methods need to be further optimized.
 *
 * @param <T>
 * isServiceDiscovery()方法用于判断是否使用服务发现。
 * getMigrationStep()方法用于获取迁移步骤。
 * setMigrationStep()方法用于设置迁移步骤。
 * getMigrationRule()方法用于获取迁移规则。
 * setMigrationRule()方法用于设置迁移规则。
 * migrateToForceInterfaceInvoker()方法用于将调用器迁移到强制接口调用器。
 * migrateToForceApplicationInvoker()方法用于将调用器迁移到强制应用调用器。
 * migrateToApplicationFirstInvoker()方法用于将调用器迁移到应用优先调用器。
 * reRefer()方法用于重新引用URL。
 */
public interface MigrationClusterInvoker<T> extends ClusterInvoker<T> {

    @Override
    boolean isServiceDiscovery();

    MigrationStep getMigrationStep();

    void setMigrationStep(MigrationStep step);

    MigrationRule getMigrationRule();

    void setMigrationRule(MigrationRule rule);

    boolean migrateToForceInterfaceInvoker(MigrationRule newRule);

    boolean migrateToForceApplicationInvoker(MigrationRule newRule);

    void migrateToApplicationFirstInvoker(MigrationRule newRule);

    void reRefer(URL newSubscribeUrl);
}
