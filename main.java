/*
 * �б�: �ѹ���б�
 * �а�: ��ǻ�Ͱ��а�
 * �й�: 20177117
 * �̸�: ������
 * 
 * ����Ʈ����� ������ ������Ʈ(���հ���) �ҽ��ڵ� �Դϴ�.
 * ������ '� �н����� ���� �ֹ� �ý���' �Դϴ�.
 * 
 * -------------- ������ ���� --------------
 * 1. Iterator: �޴������� ����Ʈ�� ��ȯ�� ���� ����
 * 2. Composite: �޴��� �����Ͽ� ���ο� ������ �޴��� �߰��Ǿ �ڵ� ������ �� ������ �ϱ� ���� ����
 * 3. Adapter: JTable�� �����ؾ� �� �ڷ����� getMenu()�� ��ȯ�޴� �ڷ����� �޶� �ڷ����� ���߱� ���� ����
 * 4. Mediator: �ֹ� â���� � �޴��� �������� ���� ��ȣ�ۿ�Ǵ� ��ư�� Ȱ��ȭ�ϱ� ���� ����
 * 5. Command: ��ư�̳� �޴��� �� ���ɾ �����ʷ� �־ �׼� �߻� �� ������ �����ϵ��� ����
 * 6. Singleton: ���̺��� ���� ������ ��� ����� �����ϰ� �ϳ��� �����ϱ� ���� ����
 * -------------------------------------
 */

package project;

class main {

	public static void main(String[] args) {
		new OrderSystem(1).run();	// 1�� ���̺�
		new OrderSystem(2).run();	// 2�� ���̺�
	}
}