""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def isBST(root, Min_range, Max_range):
    if root is None:
        return True
    if root.data <= Min_range or root.data >= Max_range:
        return False
    return isBST(root.left, Min_range, root.data) and isBST(root.right, root.data, Max_range)

def check_binary_search_tree_(root):
    Min_range = -10000
    Max_range = 10000
    return isBST(root, Min_range, Max_range)