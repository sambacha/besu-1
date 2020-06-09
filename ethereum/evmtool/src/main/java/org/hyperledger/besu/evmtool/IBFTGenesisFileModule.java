/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */
package org.hyperledger.besu.evmtool;

import javax.inject.Named;
import org.hyperledger.besu.config.GenesisConfigOptions;
import org.hyperledger.besu.consensus.ibft.IbftBlockHeaderFunctions;
import org.hyperledger.besu.consensus.ibft.IbftProtocolSchedule;
import org.hyperledger.besu.ethereum.core.BlockHeaderFunctions;
import org.hyperledger.besu.ethereum.mainnet.ProtocolSchedule;

class IBFTGenesisFileModule extends GenesisFileModule {

  IBFTGenesisFileModule(final String genesisConfig) { super(genesisConfig); }

  @Override
  ProtocolSchedule provideProtocolSchedule(
      final GenesisConfigOptions configOptions,
      @Named("RevertReasonEnabled") final boolean revertReasonEnabled) {
    return IbftProtocolSchedule.create(configOptions);
  }

  @Override
  BlockHeaderFunctions blockHashFunction() {
    return IbftBlockHeaderFunctions.forOnChainBlock();
  }
}