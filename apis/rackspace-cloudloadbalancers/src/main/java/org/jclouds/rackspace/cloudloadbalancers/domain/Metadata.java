/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.rackspace.cloudloadbalancers.domain;

import java.util.Map;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Key and value must be 256 characters or less. All UTF-8 characters are valid.
 * </p>
 * Use the *Id methods when you need to get a metadata id for updating and removal.
 * 
 * @author Everett Toews
 */
public class Metadata extends ForwardingMap<String, String> {
   private Map<String, String> metadata = Maps.newHashMap();
   private Map<String, Integer> keyToId = Maps.newHashMap();
   
   public Metadata(Metadata metadata) {
      super();
      this.metadata.putAll(metadata);
   }
   
   public Metadata() {
      super();
   }

   @Override
   protected Map<String, String> delegate() {
      return metadata;
   }
   
   public int getId(String key) {
      return keyToId.get(key);
   }
   
   public Integer putId(String key, int id) {
      return keyToId.put(key, id);
   }

   public Iterable<Integer> getIds() {
      return Sets.newHashSet(keyToId.values());
   }
}
