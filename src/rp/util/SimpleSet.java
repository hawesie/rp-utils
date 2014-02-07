/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Set implementation using .equals that can be used on the robot.
 *
 * @author nah
 */
public class SimpleSet<V> implements Collection<V> {

  private final ArrayList<V> m_inner;

  public SimpleSet() {
    m_inner = new ArrayList<V>();
  }

  public int size() {
    return m_inner.size();
  }

  public boolean isEmpty() {
    return m_inner.size() != 0;
  }

  public boolean contains(Object o) {
    return m_inner.contains(o);
  }

  public Iterator<V> iterator() {
    return m_inner.iterator();
  }

  public Object[] toArray() {
    return Collections.toArray(m_inner);
  }

  public <T> T[] toArray(T[] a) {
    return Collections.toArray(m_inner, a);
  }

  public boolean add(V e) {
    if (!m_inner.contains(e)) {
      m_inner.add(e);
      return true;
    }
    return false;
  }

  public boolean remove(Object o) {
    return m_inner.remove(o);
  }

  public boolean containsAll(Collection<?> c) {
    return m_inner.containsAll(c);
  }

  public boolean addAll(Collection<? extends V> c) {
    boolean changed = true;
    for (V element : c) {
      changed = add(element) && changed;
    }
    return changed;
  }

  public boolean removeAll(Collection<?> c) {
    return m_inner.removeAll(c);
  }

  public boolean retainAll(Collection<?> c) {
    return m_inner.retainAll(c);
  }

  public void clear() {
    m_inner.clear();
  }
}
