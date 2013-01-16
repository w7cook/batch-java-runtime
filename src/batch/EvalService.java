/*******************************************************************************
 * The accompanying source code is made available to you under the terms of 
 * the UT Research License (this "UTRL"). By installing or using the code, 
 * you are consenting to be bound by the UTRL. See LICENSE.html for a 
 * full copy of the license.
 * 
 * Copyright 2009, The University of Texas at Austin. All rights reserved.
 * 
 * UNIVERSITY EXPRESSLY DISCLAIMS ANY AND ALL WARRANTIES CONCERNING THIS 
 * SOFTWARE AND DOCUMENTATION, INCLUDING ANY WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR ANY PARTICULAR PURPOSE, NON-INFRINGEMENT AND WARRANTIES 
 * OF PERFORMANCE, AND ANY WARRANTY THAT MIGHT OTHERWISE ARISE FROM COURSE 
 * OF DEALING OR USAGE OF TRADE. NO WARRANTY IS EITHER EXPRESS OR IMPLIED 
 * WITH RESPECT TO THE USE OF THE SOFTWARE OR DOCUMENTATION. Under no circumstances 
 * shall University be liable for incidental, special, indirect, direct 
 * or consequential damages or loss of profits, interruption of business, 
 * or related expenses which may arise from use of Software or Documentation, 
 * including but not limited to those resulting from defects in Software 
 * and/or Documentation, or loss or inaccuracy of data of any kind.
 * 
 * Created by: William R. Cook and Eli Tilevich
 * with: Jose Falcon, Marc Fisher II, Ali Ibrahim, Yang Jiao, Ben Wiedermann
 * University of Texas at Austin and Virginia Tech
 ******************************************************************************/
package batch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import batch.syntax.Eval;
import batch.syntax.Evaluate;
import batch.util.BatchCancel;
import batch.util.Forest;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class EvalService<I> extends Eval implements Service<Evaluate, I> {

  /*
   * R root; rbi.runtime.Local<R> server = new rbi.runtime.Local<R>(root);
   * 
   * for (R root : server) S === S
   */

  protected I root;

  public EvalService(I root) {
    this.root = root;
  }

  public I getRoot() {
    return root;
  }

  public void setRoot(I root) {
    this.root = root;
  }

  @Override
  public ForestReader execute(Evaluate exp, ForestReader in) {
    Forest out = new Forest();
    executeServer(exp, in, out);
    return out;
  }

  public void executeServer(Evaluate exp, ForestReader in, ForestWriter result) {
    //		System.out.println("EvalService " + exp.toString());
    Map<String, Object> env = new HashMap<String, Object>();
    env.put(RootName(), root);

    try {
      exp.evaluate(env, in, result);
    } catch (BatchCancel e) {
    }

    System.out.println("Output forest: " + result.toString());
  }

  public Iterator<I> iterator() {
    System.out.println("Returning iterator");
    return new SingletonIterator<I>(root);
  }

}

class SingletonIterator<R> implements Iterator<R> {

  R value;
  boolean first = true;

  SingletonIterator(R value) {
    super();
    this.value = value;
  }

  @Override
  public boolean hasNext() {
    return first;
  }

  @Override
  public R next() {
    first = false;
    return value;
  }

  @Override
  public void remove() {
  }
}
