package org.drools.ide.flow.ruleflow.core;
/*
 * Copyright 2005 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
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

import org.drools.ide.flow.common.editor.core.ElementConnection;
import org.drools.ide.flow.common.editor.core.ElementWrapper;
import org.drools.ruleflow.core.IConnection;
import org.drools.ruleflow.core.INode;
import org.drools.ruleflow.core.impl.Connection;

/**
 * Wrapper for a connection.
 * 
 * @author <a href="mailto:kris_verlaenen@hotmail.com">Kris Verlaenen</a>
 */
public class ConnectionWrapper extends ElementConnection {
		
	private static final long serialVersionUID = 4049352037223445809L;

	private IConnection connection;
	
	public ConnectionWrapper(int type) {
		super(type);
	}
	
	public ConnectionWrapper(NodeWrapper source, NodeWrapper target, int type) {
        super(source, target, type);
    }
	
	public void disconnect() {
		super.disconnect();
		connection.terminate();
		connection = null;
	}
	
	public void connect(ElementWrapper source, ElementWrapper target) {
		super.connect(source, target);
		INode from = ((NodeWrapper) getSource()).getNode();
		INode to = ((NodeWrapper) getTarget()).getNode();
		int type = getType();
		connection = new Connection(from, to, type);		
	}
}