/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example;

import org.apache.activemq.artemis.utils.SensitiveDataCodec;

import java.util.Map;

public class DummySensitiveDataCodec implements SensitiveDataCodec<String> {
   @Override
   public String decode(Object mask) throws Exception {
      // Decode the mask into clear text password.
      System.out.println("DummySensitiveDataCodec.decode: " + mask);
      return "the password";
   }

   @Override
   public String encode(Object secret) throws Exception {
      // Mask the clear text password.
      System.out.println("DummySensitiveDataCodec.encode: " + secret);
      return "the masked password";
   }

   @Override
   public void init(Map<String, String> params) {
      // Initialization done here. It is called right after the codec has been created.
      System.out.println("DummySensitiveDataCodec.init: " + params);
   }

   @Override
   public boolean verify(char[] value, String encodedValue) {
      // Return true if the value matches the encodedValue.
      System.out.println("DummySensitiveDataCodec.verify: " + value + "/" + encodedValue);
      return true;
   }
}