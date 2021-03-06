/**
 * Appia: Group communication and protocol composition framework library
 * Copyright 2006 University of Lisbon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 * Initial developer(s): Alexandre Pinto and Hugo Miranda.
 * Contributor(s): See Appia web page for a list of contributors.
 */
 /*
 * PerfLayer.java
 *
 * Created on June 24, 2002, 2:42 PM
 */

package net.sf.appia.test.perf;

import net.sf.appia.core.*;

/**
 *
 * @author  Alexandre Pinto
 */
public class PerfLayer extends Layer {
  
  /** Creates new PerfLayer */
  public PerfLayer() {
    Class perfcast=net.sf.appia.test.perf.PerfCastEvent.class;
    Class perfsend=net.sf.appia.test.perf.PerfSendEvent.class;
    Class view=net.sf.appia.protocols.group.intra.View.class;
    Class rse=net.sf.appia.protocols.common.RegisterSocketEvent.class;
    
    evProvide=new Class[] {
        perfcast,
        perfsend,
        net.sf.appia.protocols.group.events.GroupInit.class,
        rse,
        net.sf.appia.protocols.group.leave.LeaveEvent.class,
        PerfTimer.class,
    };
    
    evRequire=new Class[] {
        view,
    };
    
    evAccept=new Class[] {
        perfcast,
        perfsend,
        view,
        net.sf.appia.protocols.group.sync.BlockOk.class,
        rse,
        net.sf.appia.core.events.channel.ChannelInit.class,
        net.sf.appia.core.events.channel.ChannelClose.class,
        PerfTimer.class,
    };
  }
  
  public Session createSession() {
    return new PerfSession(this);
  }
}
